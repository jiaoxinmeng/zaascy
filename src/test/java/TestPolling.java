import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/24.
 */
public class TestPolling implements Runnable{
    public static void main(String[] args) {
        new TestPolling().run();

    }

    /**
     * 获取目标表最新的记录修改时间
     * @return
     */
    private static Date getLastedDate(String tableName){
        Date date = null;
        Connection conn = DBUtil.getConnection();
        String sql = "select MAX(JILXGSJ) AS date from " + tableName;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                date = rs.getTimestamp("date");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return date;
    }

    /**
     * 根据上次查询的最后操作时间查询新操作记录
     * @param lastDate
     * @return
     */
    private static List<Long> getModifyIdList(Date lastDate){
        List<Long> list = new ArrayList<Long>();
        Date date = null;
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT YONGH_ID FROM XTYH WHERE JILXGSJ > ? ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1,new Timestamp(lastDate.getTime()));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Long id = rs.getLong("YONGH_ID");
                list.add(id);
                System.out.println("需要更新的id:"+id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return list;
    }

    /**
     * 根据取得的id列表新增数据入新表
     * @param ids
     * @return
     */
    private static void insertByIdList(List<Long> ids){

        if(ids!=null){
            Connection conn = DBUtil.getConnection();
            String sql = "insert into XTYH_NEW select * from XTYH WHERE XTYH.YONGH_ID IN ( ?  ";
            for(int i=1;i<ids.size();i++){
                sql = sql + ",?";
            }
            sql = sql + ")";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                for(int i=0;i<ids.size();i++){
                    ps.setLong(i+1,ids.get(i));
                }
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn);
            }
        }
    }

    /**
     * 删除已有记录
     * @param ids
     */
    private static void delByIdList(List<Long> ids){
        if(ids!=null){
            Connection conn = DBUtil.getConnection();
            String sql = "DELETE FROM XTYH_NEW where YONGH_ID in ( ? ";
            for(int i=1;i<ids.size();i++){
                sql = sql + ",?";
            }
            sql = sql + ")";
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                for(int i=0;i<ids.size();i++) ps.setLong(i + 1, ids.get(i));
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                DBUtil.close(conn);
            }
        }
    }

    /**
     * 得到目标表删除记录
     * @return
     */
    public static List<Long> getDelIdList(){
        List<Long> list = new ArrayList<Long>();
        Connection conn = DBUtil.getConnection();
        String sql = "SELECT XTYH_NEW.YONGH_ID FROM XTYH_NEW WHERE XTYH_NEW.YONGH_ID NOT IN (SELECT XTYH.YONGH_ID FROM XTYH)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Long id = rs.getLong("YONGH_ID");
                list.add(id);
                System.out.println("需要删除的id为:"+id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
        return list;
    }

    /**
     * 新增日志
     * @param date  原表最后更新时间
     * @param remark    备注
     * @param count 操作记录数
     */
    public static void insertLog(Date date,String remark, Integer count){
        Connection conn = DBUtil.getConnection();
        String sql = "insert into XTYH_NEW_LOG VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setTimestamp(1,new Timestamp(date.getTime()));
            ps.setTimestamp(2,new Timestamp((new Date()).getTime()));
            ps.setString(3," ");
            ps.setInt(4,count);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn);
        }
    }

    /**
     * 一次完整轮询操作
     */
    public static void oneSearch(){
        Long startTime = System.currentTimeMillis();
        Date date_log = getLastedDate("XTYH_NEW");
        Date date = getLastedDate("XTYH");
        List<Long> ids_d = getDelIdList();
        List<Long> ids_m = new ArrayList<Long>();
        //首先判断原表有无删除记录
        if(ids_d!=null&&ids_d.size()>0){
            delByIdList(ids_d);
            System.out.println("删除记录条数:"+ids_d.size());
        }
        //其次判断有无更新记录
        if(date_log.compareTo(date)>=0){
            System.out.println("更新记录条数:0");
        }else{
            ids_m = getModifyIdList(date_log);
            delByIdList(ids_m);
            insertByIdList(ids_m);
            System.out.println("更新记录条数:"+ids_m.size());
        }
        insertLog(date,"",ids_d.size()+ids_m.size());
        Long endTime = System.currentTimeMillis();
        System.out.println("----------一次轮询成功,本次用时"+(endTime-startTime)+"------------------");
    }

    public void run() {
        while(true){
            try {
                oneSearch();
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

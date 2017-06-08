package com.netcenter.zaascy.service.impl;

import com.netcenter.zaascy.bean.*;
import com.netcenter.zaascy.dao.*;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.util.MessageStub;
import com.netcenter.zaascy.util.MssUtil;
import com.netcenter.zaascy.util.SecurityUtil;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2017/3/20.
 */
@Service(value = "commonService")
public class CommonServiceImpl implements CommonService{
    //科技成果转化模块ID
    private final static int moduleId = 720;

    @Resource(name="departDao")
    private DepartMapper departDao;

    @Resource(name = "tradeResourceDao")
    private TradeResourceMapper resourceDao;

    @Resource(name = "userDao")
    private UserMapper userDao;

    @Resource(name="moduleDao")
    private ModuleMapper moduleDao;

    @Resource(name="roleRelationDao")
    private RoleRelationMapper roleRelationDao;

    @Resource(name="privilegeDao")
    private PrivilegeMapper privilegeDao;

    @Resource(name="tradeDao")
    private TradeMapper tradeDao;

    @Resource(name = "taskExecutor")
    private TaskExecutor taskExecutor;

    public List<Depart> getDepartList() {
        return departDao.getAll();
    }

    public List<Depart> getInstituteList(){return departDao.getAllInstitute();}

    public List<TradeResource> getResourceByType(String type){
        return resourceDao.selectByType(type);
    }

    public String getDepartNumBydepartId(Integer departId) {
        return departDao.getDepartNumById(departId);
    }

    public boolean valiDatePassword(String username, String password) {
        String password_db = userDao.findPasswordByLoginname(username);
        try {
            if(password_db!=null&&password_db.equals(SecurityUtil.encryptMessage(password))){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean valiDateUsername(String username) {
        String password_db = userDao.findPasswordByLoginname(username);
        if(password_db!=null){
            return  true;
        }
        return false;
    }

    public User getUser(String username, String password) {
        try {
            return userDao.getUserByUsername(username,SecurityUtil.encryptMessage(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSubmitorsByModuleId(int moduleId) {
        return moduleDao.getSubmitors(moduleId);
    }

    public String getAssessorsByModuleId(int moduleId) {
        return moduleDao.getAssessors(moduleId);
    }

    public List<RoleRelationKey> getRelosByUserId(Long userId) {
        return roleRelationDao.getRelosByUserId(userId);
    }

    public List<Privilege> getPrivilegeByUserIdAndModuleId(Long userId, int moduleId) {
        return privilegeDao.getPrivilege(userId,moduleId);
    }

    public String getDepartFullNameById(Integer departId) {
        return departDao.getDepartFullNameById(departId);
    }

    public List<String> getProjectTypeList() {
        return resourceDao.getProjectTypeList();
    }

    public List<String> getUsers(Long departId) {
        List<String> list = new ArrayList<String>();
        List<User> userList = userDao.getUserByDepartId(departId);
        for(User user:userList){
            list.add(user.getYonghId()+"|"+user.getXingm());
        }
        return list;
    }

    public List<String> getUsers(Long departId, Integer personType) {
        List<String> list = new ArrayList<String>();
        List<User> userList = userDao.getUserByDepartIdAndPersonType(departId,personType);
        for(User user:userList){
            list.add(user.getYonghId()+"|"+user.getXingm());
        }
        return list;
    }

    public void sendMessageBytype(String type, Long tradeId) {
        String messageContent = "";
        String sendNumber = "";
        if(tradeId==null){
            System.out.println("记录ID为空");
            //return "记录ID为空";
        }

        Trade trade = tradeDao.selectByPrimaryKey(tradeId);

        if(trade==null){
            System.out.println("未查到记录");
            //return "未查到记录";
        }
        Date nowDate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String nowDate_str = simpleDateFormat.format(nowDate);

        if(type==null){
            System.out.println("类型为空");
            //return "类型为空";
        }else if(type.equals("submit")){
            //[ 成转系统 ] depart_mark所管理员于date_mark提交type_mark类项目一项，请予审核。
            messageContent = resourceDao.getMessageContentByType(type);
            if(messageContent==null||messageContent.equals("")){
                System.out.println("短信内容查找失败");
                //return "短信内容查找失败";
            }
            messageContent = messageContent.replaceAll("depart_mark",trade.getDepart()).replaceAll("date_mark",nowDate_str).replaceAll("type_mark",trade.getProjectType()).replaceAll("projectName_mark",trade.getProjectName());
            // 先去查询记录审核人id，存在则是退回状态，向原审核人发短信提醒 此处为yongh_id
            // 不存在则需查询本栏目审核人列表，注意返回值为String（111,222）且此处为reny_id
            // trade.getAssessorId()
            if(trade.getAssessorId()!=null){
                sendNumber = userDao.getOneColumnById(trade.getAssessorId(),"shouj","yongh_id");
            }else{
                String assessors =  moduleDao.getAssessors(moduleId);
                if(assessors==null){
                    System.out.println("未查询到该模块审核人ID");
                    //return "未查询到该模块审核人ID";
                }
                String[] str = assessors.split(",");
                for(int i=0;i<str.length;i++){
                    if(str[i].trim().equals("")){
                        str[i] = "0";
                    }
                    sendNumber = userDao.getOneColumnById(new Long(str[i].trim()),"shouj","reny_id");
                }
            }
        }else if(type.equals("access")||type.equals("back")){
            messageContent = resourceDao.getMessageContentByType(type);
            if(messageContent==null||messageContent.equals("")){
                System.out.println("短信内容查找失败");
               // return "短信内容查找失败";
            }
            messageContent = messageContent.replaceAll("depart_mark",trade.getDepart()).replaceAll("date_mark",nowDate_str).replaceAll("type_mark",trade.getProjectType()).replaceAll("projectName_mark",trade.getProjectName());
            if(trade.getAssessorId()!=null){
                sendNumber = userDao.getOneColumnById(trade.getSubmiterId(),"shouj","yongh_id");
            }else{
                System.out.println("未找到正确的提交人ID");
                //return "未找到正确的提交人ID";
            }
        }else{
            System.out.println("未知参数");
            //return "未知参数";
        }

        if(!valiMobiePhoneNum(sendNumber)){
            System.out.println("不合法的手机号码");
            //return "不合法的手机号码";
        }

        System.out.println(sendNumber+"----"+messageContent);

        //发送
//         String returnStr = MssUtil.sendSms(messageContent,sendNumber);
        try {
            final String finalMessageContent = messageContent;
            final String finalSendNumber = sendNumber;
            taskExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println("成功启用线程池");
                    String returnStr = MssUtil.sendSms(finalMessageContent, finalSendNumber);
                    if(returnStr!=null&&returnStr.contains("成功")){
                        System.out.println("发送成功");
                       // return "success";
                    }else{
                        System.out.println("发送失败");
                       // return "接口调用错误";
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Boolean valiMobiePhoneNum(String phoneNum){
        if(phoneNum==null){
            return false;
        }
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0-9]))\\d{8}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(phoneNum);
        if(m.matches()){
            return true;
        }else{
            return false;
        }
    }
}

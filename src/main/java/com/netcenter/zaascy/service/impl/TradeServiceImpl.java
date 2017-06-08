package com.netcenter.zaascy.service.impl;

import com.netcenter.zaascy.bean.*;
import com.netcenter.zaascy.dao.*;
import com.netcenter.zaascy.service.TradeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service(value="tradeService")
public class TradeServiceImpl implements TradeService,Serializable {

    private final static int moduleId = 720;

    @Resource(name="tradeDao")
    private TradeMapper dao;

    @Resource(name="tradeChildDao")
    private TradeChildMapper childDao;

    @Resource(name="tradeMemberDao")
    private TradeMemberMapper memberDao;

    @Resource(name="tradeFundsDao")
    private TradeFundsMapper fundsDao;

    @Resource(name="tradeSubsidiaryDao")
    private TradeSubsidiaryMapper tradeSubsidiaryDao;

    @Resource(name="departDao")
    private DepartMapper departDao;

    @Resource(name = "userDao")
    private UserMapper userDao;

    @Resource(name="moduleDao")
    private ModuleMapper moduleDao;

    @Resource(name="roleRelationDao")
    private RoleRelationMapper roleRelationDao;

    @Resource(name="privilegeDao")
    private PrivilegeMapper privilegeDao;

    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int insert(Trade record) {
        return dao.insert(record);
    }

    public int insertSelective(Trade record) {
        record.setCreateDate(new Date());
        return dao.insertSelective(record);
    }

    public Trade selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Trade record) {
        return dao.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Trade record) {
        return dao.updateByPrimaryKey(record);
    }

    public List<Trade> selectAll() {
        return dao.selectAll();
    }

    public List<TradeChild> selectAllTradeChildByQuarter(String quarter) {
        return childDao.selectAll();
    }

    public int insertTradeChildsByQuarty() {
        return 0;
    }

    public List<String> getZaasCodeListByZaasTechType(String zaasTechType, Integer departId, Integer year) {
        if(zaasTechType.equals("实用技术")){
            return new ArrayList<String>();
        }
        return dao.getZaasCodeListByZaasTechType(zaasTechType,departId,year);
    }

    public String getNameByZaasCode(String zassCode){
        // 获取年份
        Integer year = Integer.valueOf(zassCode.substring(0, 4));

        // 获取编码标识符 类别
        String mark = "";
        if (year <= 2015) {
            mark = zassCode.substring(4, 6);
        } else {
            mark = zassCode.substring(7, 9);
        }
        if(mark.equals("JS")){
            return "";
        }
        return dao.getNameByZaasCode(mark,zassCode);
    }

    public String getSerialNum(String mark) {
        String projectNum = dao.getProjectNumByMark(mark);
        if(projectNum!=null){
            String serialNum = projectNum.replace(mark,"");
            Integer result = Integer.parseInt(serialNum) + 1;
            return toString(result);
        }else{
            return "001";
        }
    }

    public void saveTrade(Trade trade) {
        if(trade.getId()==null||trade.getId()==0){
            trade.setCreateDate(new Date());
            dao.insertSelective(trade);
        }else{
            trade.setModifyDate(new Date());
            dao.updateByPrimaryKeySelective(trade);
        }
    }

    public void submit(Long id, Long userId, String name) {
        dao.workflow(id,userId,name,1,0,new Date());
    }

    public void saveTradeChild(TradeChild tradeChild) {
        childDao.insertSelective(tradeChild);
    }

    public void delChild(String year, String quarter) {
        childDao.delChildByYearAndQuarter(year,quarter);
    }

    public Long addTradeByChild(Integer year, String quarter,String remarks,Long userId,String username) {
        Integer count = childDao.getCount(year,quarter);
        Long id = 0L;
        if(count>0){
            Trade trade = new Trade();
            //项目编号
            trade.setProjectNum(getProjectNum(year,quarter));
            //年份
            trade.setProjectYear(year);
            //单位
            trade.setDepartId(new Long(55));
            trade.setDepart(departDao.getDepartNameById(55));
            //项目类别
            trade.setProjectType("检测服务");
            //类别代码
            trade.setProjectTypeCode("J1");
            //项目名称
            trade.setProjectName((year+quarter+"检测单"));
            //院成果技术类型
            trade.setZaasTechType("实用技术");
            //院成果技术编码
            trade.setZaasCode("2017R19JS001");
            //委托/受让单位全称
            trade.setCustomerDepart(childDao.getColumnStr("provide_unit",year,quarter));
            //让与/承担单位全称
            trade.setDepartFullName(departDao.getDepartFullNameById(55));
            //项目负责人
            trade.setProjectPerson(childDao.getColumnStr("manager",year,quarter));
            //起始年月
            try {
                trade.setStartDate(getStartDateByQuarter(year,quarter));
                //终止年月
                trade.setEndDate(getEndDateByQuarter(year,quarter));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            //意向总金额
            trade.setIntentionAmount(childDao.getSumAmount(year, quarter));
            //项目内容简介
            trade.setProjectSummary("质标所检测中心"+year+quarter+"检测单汇总,共"+count+"单，实收"+(trade.getIntentionAmount().divide(new BigDecimal("10000"), 2, RoundingMode.HALF_UP) )+"万元");
            //意向金额与付款方式说明
            trade.setIntentionAmountExplain("");
            //签约总金额
            trade.setSignAmount(trade.getIntentionAmount());
            //备注
            trade.setRemarks(remarks);
            //提交人
//            trade.setSubmiterId(userId);
//            trade.setSubmiter(username);
            //审核人
            //提交状态
            trade.setSubmitState(0);
            //审核状态
            trade.setAssessState(0);
            //合同下载状态
            //trade.setDownloadState(new Date());
            //交易行为同步状态
            trade.setJoinState(0);
            //控制字段
            trade.setOperatorId(userId);
            trade.setOperator(username);
            trade.setCreateDate(new Date());
            trade.setModifyDate(new Date());
            dao.insertSelective(trade);
            id = trade.getId();
        }
        return id;
    }

    public Integer getChildCount(Integer year, String quarter) {
        return childDao.getCount(year,quarter);
    }

    public Integer getTradeCount(Integer year, String quarter) {
        return dao.getCount(getProjectNum(year,quarter));
    }

    public List<TradeMember> getMembers(Long projectId) {
        return memberDao.selectByProjectId(projectId);
    }

    public TradeMember getMemberById(Long id) {
        return memberDao.selectByPrimaryKey(id);
    }

    public Integer getTradeCountByType(String typeCode) {
        return dao.getCountByType(typeCode);
    }

    public List<Trade> getListByType(String codeType, Long userId) {
        //查询用户角色
        List<RoleRelationKey> roleRelationKeys = roleRelationDao.getRelosByUserId(userId);
        if(roleRelationKeys!=null && roleRelationKeys.size()>0){
            for (RoleRelationKey relo : roleRelationKeys){
                if(relo.getJuesId()==33||relo.getJuesId()==1){
                    return dao.selectByType(codeType);
                }
            }
        }

        //查询审核者列表
        String assessors = moduleDao.getAssessors(moduleId);
        String renyId = userDao.getOneColumnById(userId,"reny_id","yongh_id");
        if(renyId!=null&&assessors!=null && assessors.contains(renyId)){
            return dao.selectByType(codeType);
        }

        //查询提交者权限
        String submitors = moduleDao.getSubmitors(moduleId);
        String departId = userDao.getOneColumnById(userId,"danw_id","yongh_id");
        if(renyId!=null&&submitors!=null && submitors.contains(renyId)){
            return dao.selectByTypeAndDepartId(codeType,departId);
        }

        //查询具体权限
        List<Privilege> privileges = privilegeDao.getPrivilege(userId,moduleId);
        if(privileges!=null && privileges.size()>0){
            for(Privilege privilege : privileges){
                if(privilege.getJuesjb()==60){
                    return dao.selectByType(codeType);
                }else if(privilege.getJuesjb()==40){
                    return dao.selectByTypeAndDepartId(codeType,departId);
                }
            }
        }

        //查询个人参与项目权限
        return dao.selectByTypeAndUserId(codeType,userId);
    }

    public void delMemberById(Long id) {
        memberDao.deleteByPrimaryKey(id);
    }

    public void saveTradeMember(TradeMember member, Long yonghId, String xingm) {
        member.setOperatorId(yonghId);
        member.setOperator(xingm);
        if(member.getId()!=null){
            member.setModifyDate(new Date());
            memberDao.updateByPrimaryKeySelective(member);

        }else{
            member.setCreateDate(new Date());
            memberDao.insertSelective(member);

        }
    }

    public List<TradeFunds> getFunds(Long projectId) {
        return fundsDao.selectFundsByProjectId(projectId);
    }

    public TradeFunds getFundsById(Long id) {
        return fundsDao.selectByPrimaryKey(id);
    }

    public void delFundsById(Long id) {
        fundsDao.deleteByPrimaryKey(id);
    }

    @Transactional(rollbackFor={Exception.class})
    public void saveFunds(TradeFunds funds, Long yonghId, String xingm) {
        funds.setOperatorId(yonghId);
        funds.setOperator(xingm);
        //如果id为空 则是新增
        if(funds.getId()==null){
            funds.setCreateDate(new Date());
            fundsDao.insertSelective(funds);

            Trade trade = dao.selectByPrimaryKey(funds.getProjectId());

            //如果是第一次新增  不用计算加和  否则相加
            if(trade.getReceivedAmount()==null){
                trade.setReceivedAmount(funds.getFunds());
            }else{
                trade.setReceivedAmount(trade.getReceivedAmount().add(funds.getFunds()));
            }

            dao.updateByPrimaryKeySelective(trade);
        }else{
            //更新前获取原始数据
            TradeFunds funds_old = fundsDao.selectByPrimaryKey(funds.getId());

            funds.setModifyDate(new Date());
            fundsDao.updateByPrimaryKeyWithBLOBs(funds);

            Trade trade = dao.selectByPrimaryKey(funds.getProjectId());
            //更新时 先减去原始值再加上新值
            trade.setReceivedAmount(trade.getReceivedAmount().subtract(funds_old.getFunds()).add(funds.getFunds()));

            dao.updateByPrimaryKeySelective(trade);
        }



    }

    @Transactional(rollbackFor={Exception.class})
    public void access(Long id, Long userId, String username) {
        //审核时，生成项目编码
        Trade trade = dao.selectByPrimaryKey(id);

        if(trade.getProjectNum()==null){
            String departNum = departDao.getDepartNumById(trade.getDepartId().intValue());
            String mark = trade.getProjectYear() + departNum.trim() + trade.getProjectTypeCode().trim();
            String serialNum = getSerialNum(mark);

            trade.setProjectNum(mark+serialNum);
        }



        dao.updateByPrimaryKeySelective(trade);
        dao.workflow(id,userId,username,1,1,new Date());
    }

    public List<TradeSubsidiary> getSubsidiaryList(Long projectId) {
        return tradeSubsidiaryDao.getSubsidiaryListByProjectId(projectId);
    }

    public Integer getFundsCountByProjectId(Long id) {
        return fundsDao.getCountByProjectId(id);
    }

    public Integer getMembersCountByProjectId(Long projectId) {
        return memberDao.getMembersCountByProjectId(projectId);
    }

    public Integer getSubsidiaryCountByProjectId(Long projectId) {
        return tradeSubsidiaryDao.getSubsidiaryCountByProjectId(projectId);
    }

    public List<TradeSubsidiary> getOtherZaasCodes(Long projectId) {
        return tradeSubsidiaryDao.getSubsidiaryListByProjectId(projectId);
    }

    public void saveTradeSubsidiary(TradeSubsidiary subsidiary,Long userId,String username) {
        subsidiary.setOperatorId(userId);
        subsidiary.setOperator(username);
        if(subsidiary.getId()==null){
            subsidiary.setCreateDate(new Date());
            tradeSubsidiaryDao.insertSelective(subsidiary);
        }else{
            subsidiary.setModifyDate(new Date());
            tradeSubsidiaryDao.updateByPrimaryKeySelective(subsidiary);
        }
    }

    public void delSubsidiaryById(Long id) {
        tradeSubsidiaryDao.deleteByPrimaryKey(id);
    }

    public void delFundsByProjectId(Long projectId) {
        fundsDao.deleteByProjectId(projectId);
    }

    public void delMemberByProjectId(Long projectId) {
        memberDao.deleteByProjectId(projectId);
    }

    public void delSubsidiaryByProjectId(Long projectId) {
        tradeSubsidiaryDao.delSubsidiaryByProjectId(projectId);
    }

    public void delChildByProjectId(Long id) {
        Trade trade = dao.selectByPrimaryKey(id);
        if(trade!=null){
            childDao.delChildByYearAndQuarter(trade.getProjectYear().toString(),getQuarter(trade.getProjectNum()));
        }
    }

    public void back(Long id, Long userId, String username) {
        dao.workflow(id,userId,username,0,1,new Date());
    }

    public void notAccess(Long id, Long userId, String username) {
        dao.workflow(id,userId,username,1,0,new Date());
    }

    public List<HashMap<String,Integer>> getCharts(String columName, Boolean whereMark, String colunNameWhere, String nameWhere) {
        return dao.getCharts(columName,whereMark,colunNameWhere,nameWhere);
    }

    public Integer getProjectCountByUserId(Long userId) {
        return memberDao.getProjectCountByUserId(userId);
    }


    public String toString(Integer num){
        if(num==null){
            return "0";
        }else if(num.toString().length()<2){
            return "00"+num.toString();
        }else if(num.toString().length()<3){
            return "0"+num.toString();
        }else{
            return num.toString();
        }
    }

    public Date getStartDateByQuarter(Integer year,String quarter) throws ParseException {
        if(year==null||quarter==null){
            return null;
        }
        if(quarter.equals("第一季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-01-01");
        }else if(quarter.equals("第二季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-04-01");
        }else if(quarter.equals("第三季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-07-01");
        }else if(quarter.equals("第四季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-10-01");
        }
        return null;
    }

    public Date getEndDateByQuarter(Integer year,String quarter) throws ParseException {
        if(year==null||quarter==null){
            return null;
        }
        if(quarter.equals("第一季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-03-31");
        }else if(quarter.equals("第二季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-6-30");
        }else if(quarter.equals("第三季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-9-30");
        }else if(quarter.equals("第四季度")){
            return new SimpleDateFormat("yyyy-MM-dd").parse(year.toString()+"-12-31");
        }
        return null;
    }

    public String getProjectNum(Integer year ,String quarter){
        String projectNum = year+departDao.getDepartNumById(55).trim()+"J1";
        if(quarter.equals("第一季度")){
            projectNum += "001";
        }else if(quarter.equals("第二季度")){
            projectNum += "002";
        }else if(quarter.equals("第三季度")){
            projectNum += "003";
        }else if(quarter.equals("第四季度")){
            projectNum += "004";
        }
        return projectNum;
    }

    public String getQuarter(String projectNum){
        if(projectNum==null){
            return "";
        }else if(projectNum.contains("001")){
            return "第一季度";
        }else if(projectNum.contains("002")){
            return "第二季度";
        }else if(projectNum.contains("003")){
            return "第三季度";
        }else if(projectNum.contains("004")){
            return "第四季度";
        }
        return "";
    }
}

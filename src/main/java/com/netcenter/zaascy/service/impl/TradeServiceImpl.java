package com.netcenter.zaascy.service.impl;

import com.netcenter.zaascy.bean.*;
import com.netcenter.zaascy.dao.*;
import com.netcenter.zaascy.service.TradeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/3/16.
 */
@Service(value="tradeService")
public class TradeServiceImpl implements TradeService,Serializable {

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
            return "0001";
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
        dao.submit(id,userId,name,1,new Date());
    }

    public void saveTradeChild(TradeChild tradeChild) {
        childDao.insertSelective(tradeChild);
    }

    public void delChild(String year, String quarter) {
        childDao.delChildByYearAndQuarter(year,quarter);
    }

    public int addTradeByChild(Integer year, String quarter,String remarks,Long userId,String username) {
        Integer count = childDao.getCount(year,quarter);
        Integer id = 0;
        if(count>0){
            Trade trade = new Trade();
            //项目编号
            trade.setProjectNum(getProjectNum(year,quarter));
            //年份
            trade.setProjectYear(year);
            //单位
            trade.setDepartId("55");
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
            trade.setSubmiterId(userId);
            trade.setSubmiter(username);
            //审核人
            //提交状态
            trade.setSubmitState(0);
            //审核状态
            trade.setAssessState(0);
            //合同下载状态
            trade.setDownloadState(0);
            //交易行为同步状态
            trade.setJoinState(0);
            //控制字段
            trade.setOperatorId(userId);
            trade.setOperator(username);
            trade.setCreateDate(new Date());
            trade.setModifyDate(new Date());
            id = dao.insertSelective(trade);
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
        return memberDao.selectById(id);
    }

    public Integer getTradeCountByType(String typeCode) {
        return dao.getCountByType(typeCode);
    }

    public List<Trade> getListByType(String codeType) {
        return dao.selectByType(codeType);
    }

    public void delMemberById(Long id) {
        memberDao.deleteById(id);
    }

    public void saveTradeMember(TradeMember member) {
        if(member.getId()!=null){
            memberDao.updateSelective(member);
        }else{
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

    public void saveFunds(TradeFunds funds) {
        if(funds.getId()==null){
            fundsDao.insertSelective(funds);
        }else{
            fundsDao.updateByPrimaryKeyWithBLOBs(funds);
        }
    }

    public void access(Long id, Long userId, String username) {
        dao.access(id,userId,username,1,new Date());
    }

    public List<TradeSubsidiary> getSubsidiaryList(Long projectId) {
        return tradeSubsidiaryDao.getSubsidiaryListByProjectId(projectId);
    }

    public Integer getFundsCountByProjectId(Long id) {
        return fundsDao.getCountByProjectId(id);
    }

    public Integer getMembersCountByProjectId(Long id) {
        return null;
    }

    public Integer getSubsidiaryCountByProjectId(Long id) {
        return null;
    }


    public String toString(Integer num){
        if(num==null){
            return "0";
        }else if(num.toString().length()<2){
            return "000"+num.toString();
        }else if(num.toString().length()<3){
            return "00"+num.toString();
        }else if(num.toString().length()<4){
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
}

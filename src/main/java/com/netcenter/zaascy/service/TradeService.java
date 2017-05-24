package com.netcenter.zaascy.service;

import com.netcenter.zaascy.bean.*;

import java.util.List;


/**
 * Created by Administrator on 2017/3/16.
 */
public interface TradeService {
    int deleteByPrimaryKey(Long id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);

    List<Trade> selectAll();

    List<TradeChild> selectAllTradeChildByQuarter(String quarter);

    int insertTradeChildsByQuarty();

    List<String> getZaasCodeListByZaasTechType(String zaasTechType, Integer departId, Integer year);

    String getNameByZaasCode(String zassCode);

    String getSerialNum(String mark);

    void saveTrade(Trade trade);

    void submit(Long id, Long userId, String name);

    void saveTradeChild(TradeChild tradeChild);

    void delChild(String year, String quarter);

    int addTradeByChild(Integer year, String quarter,String remarks,Long userId,String username);

    Integer getChildCount(Integer year, String quarter);

    Integer getTradeCount(Integer year, String quarter);

    List<TradeMember> getMembers(Long projectId);

    TradeMember getMemberById(Long id);

    Integer getTradeCountByType(String typeCode);

    List<Trade> getListByType(String codeType);

    void delMemberById(Long id);

    void saveTradeMember(TradeMember member);

    List<TradeFunds> getFunds(Long projectId);

    TradeFunds getFundsById(Long id);

    void delFundsById(Long id);

    void saveFunds(TradeFunds funds);

    void access(Long id, Long userId, String username);

    List<TradeSubsidiary> getSubsidiaryList(Long projectId);

    Integer getFundsCountByProjectId(Long id);

    Integer getMembersCountByProjectId(Long id);

    Integer getSubsidiaryCountByProjectId(Long id);

}

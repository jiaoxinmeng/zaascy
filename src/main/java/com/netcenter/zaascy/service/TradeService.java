package com.netcenter.zaascy.service;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeChild;

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
}

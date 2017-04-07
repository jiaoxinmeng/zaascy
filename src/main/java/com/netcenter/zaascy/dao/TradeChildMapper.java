package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeChild;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tradeChildDao")
public interface TradeChildMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeChild record);

    int insertSelective(TradeChild record);

    TradeChild selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeChild record);

    int updateByPrimaryKey(TradeChild record);

    List<TradeChild> selectAll();
}
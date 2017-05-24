package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "tradeResourceDao")
public interface TradeResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeResource record);

    int insertSelective(TradeResource record);

    TradeResource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeResource record);

    int updateByPrimaryKey(TradeResource record);

    List<TradeResource> selectByType(String type);

    List<String> getProjectTypeList();
}
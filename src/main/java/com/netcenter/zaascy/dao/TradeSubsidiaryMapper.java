package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeSubsidiary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "tradeSubsidiaryDao")
public interface TradeSubsidiaryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeSubsidiary record);

    int insertSelective(TradeSubsidiary record);

    TradeSubsidiary selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeSubsidiary record);

    int updateByPrimaryKey(TradeSubsidiary record);

    List<TradeSubsidiary> getSubsidiaryListByProjectId(Long projectId);

    void delSubsidiaryByProjectId(Long projectId);
}
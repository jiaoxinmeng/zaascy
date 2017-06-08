package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeFunds;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tradeFundsDao")
public interface TradeFundsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeFunds record);

    int insertSelective(TradeFunds record);

    TradeFunds selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeFunds record);

    int updateByPrimaryKeyWithBLOBs(TradeFunds record);

    int updateByPrimaryKey(TradeFunds record);

    List<TradeFunds> selectFundsByProjectId(Long projectId);

    Integer getCountByProjectId(Long projectId);

    void deleteByProjectId(Long projectId);
}
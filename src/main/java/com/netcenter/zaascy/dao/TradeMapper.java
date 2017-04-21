package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Trade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository("tradeDao")
public interface TradeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Trade record);

    int insertSelective(Trade record);

    Trade selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Trade record);

    int updateByPrimaryKey(Trade record);

    List<Trade> selectAll();

    List<String> getZaasCodeListByZaasTechType(@Param("zaasTechType") String zaasTechType, @Param("departId")Integer departId, @Param("year")Integer year);

    String getNameByZaasCode(@Param("mark")String mark,@Param("zaasCode")String zaasCode);
}
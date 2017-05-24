package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeChild;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
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

    void delChildByYearAndQuarter(@Param("year") String year, @Param("quarter") String quarter);

    String getColumnStr(@Param("columnName")String columnName,@Param("year")Integer year,@Param("quarter")String quarter);

    String getColumnInt(@Param("columnName")String columnName,@Param("year")Integer year,@Param("quarter")String quarter);

    BigDecimal getSumAmount(@Param("year")Integer year, @Param("quarter")String quarter);

    Integer getCount(@Param("year")Integer year, @Param("quarter")String quarter);
}
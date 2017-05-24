package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Trade;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
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

    String getProjectNumByMark(@Param("mark")String mark);

    void submit(@Param("id")Long id, @Param("userId")Long userId, @Param("name")String name, @Param("submitState")int submitState, @Param("date")Date date);

    Trade selectByProjectNum(String projectNum);

    Integer getCount(String projectNum);

    Integer getCountByType(String typeCode);

    List<Trade> selectByType(String codeType);

    void access(@Param("id")Long id, @Param("userId")Long userId, @Param("username")String username, @Param("accessState")int accessState, @Param("date")Date date);
}
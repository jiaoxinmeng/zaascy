package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.ChartsDemo;
import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeMember;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.HashMap;
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

    Trade selectByProjectNum(String projectNum);

    Integer getCount(String projectNum);

    Integer getCountByType(String codeType);

    List<Trade> selectByType(String codeType);

    List<Trade> selectByTypeAndDepartId(@Param("codeType")String codeType,@Param("departId")String departId);

    List<Trade> selectByTypeAndUserId(@Param("codeType")String codeType, @Param("userId")Long userId);

    Trade getProjectNumById(Long projectId);

    void workflow(@Param("id")Long id, @Param("userId")Long userId, @Param("name")String name, @Param("submitState")int submitState, @Param("accessState")int accessState,@Param("date")Date date);

    List<HashMap<String,Integer>> getCharts(@Param("columName")String columName, @Param("whereMark")Boolean whereMark, @Param("colunNameWhere")String colunNameWhere, @Param("nameWhere")String nameWhere);


}
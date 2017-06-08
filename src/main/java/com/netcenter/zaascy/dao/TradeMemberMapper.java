package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tradeMemberDao")
public interface TradeMemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TradeMember record);

    int insertSelective(TradeMember record);

    TradeMember selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TradeMember record);

    int updateByPrimaryKey(TradeMember record);

    List<TradeMember> selectByProjectId(Long projectId);

    void deleteByProjectId(Long projectId);

    String getProjectNumById(Long id);

    Integer getMembersCountByProjectId(Long projectId);

    Integer getProjectCountByUserId(Long userId);
}
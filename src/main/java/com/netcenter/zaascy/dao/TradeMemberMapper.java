package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeMember;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("tradeMemberDao")
public interface TradeMemberMapper {
    int insert(TradeMember record);

    int insertSelective(TradeMember record);

    TradeMember selectById(Long id);

    List<TradeMember> selectByProjectId(Long projectId);

    void deleteById(Long id);

    void updateSelective(TradeMember record);

    void deleteByProjectId(Long projectId);
}
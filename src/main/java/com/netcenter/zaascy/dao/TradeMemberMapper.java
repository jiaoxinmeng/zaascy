package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.TradeMember;

public interface TradeMemberMapper {
    int insert(TradeMember record);

    int insertSelective(TradeMember record);
}
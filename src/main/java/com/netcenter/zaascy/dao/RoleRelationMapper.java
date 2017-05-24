package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.RoleRelationKey;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "roleRelationDao")
public interface RoleRelationMapper {
    List<RoleRelationKey> getRelosByUserId(Long userId);
}
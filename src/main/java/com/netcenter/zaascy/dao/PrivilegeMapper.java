package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Privilege;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository(value = "privilegeDao")
public interface PrivilegeMapper {
    List<Privilege> getPrivilege(@Param("userId") Long userId, @Param("moduleId") int moduleId);
}
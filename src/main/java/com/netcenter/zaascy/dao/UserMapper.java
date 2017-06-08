package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Repository("userDao")
public interface UserMapper {


    User selectByPrimaryKey(Long yonghId);


    Integer selectByUsername(String username);

    String findPasswordByLoginname(String username);

    User getUserByUsername(@Param("username") String username, @Param("password") String password);

    List<User> getUserByDepartId(Long departId);

    List<User> getUserByDepartIdAndPersonType(@Param("departId")Long departId,@Param("personType")Integer personType);

    String getOneColumnById(@Param("id")Long id,@Param("columnName")String columnName,@Param("columnKeyName")String columnKeyName);
}
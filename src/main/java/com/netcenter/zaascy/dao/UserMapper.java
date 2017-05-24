package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Repository("userDao")
public interface UserMapper {
    int deleteByPrimaryKey(Long yonghId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long yonghId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    Integer selectByUsername(String username);

    String findPasswordByLoginname(String username);

    User getUserByUsername(@Param("username") String username, @Param("password") String password);
}
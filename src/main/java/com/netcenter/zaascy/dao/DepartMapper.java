package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Depart;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository(value = "departDao")
public interface DepartMapper {
    int deleteByPrimaryKey(BigDecimal danwId);

    int insert(Depart record);

    int insertSelective(Depart record);

    Depart selectByPrimaryKey(BigDecimal danwId);

    int updateByPrimaryKeySelective(Depart record);

    int updateByPrimaryKey(Depart record);

    List<Depart> getAll();

    List<Depart> getAllInstitute();
}
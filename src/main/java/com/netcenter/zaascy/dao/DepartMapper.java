package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Depart;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository(value = "departDao")
public interface DepartMapper {

    List<Depart> getAll();

    List<Depart> getAllInstitute();

    String getDepartNumById(Integer departId);

    String getDepartFullNameById(Integer departId);

    String getDepartNameById(Integer departId);
}
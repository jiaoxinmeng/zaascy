package com.netcenter.zaascy.dao;

import com.netcenter.zaascy.bean.Module;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository(value = "moduleDao")
public interface ModuleMapper {
    String getSubmitors(int moduleId);

    String getAssessors(int moduleId);
}
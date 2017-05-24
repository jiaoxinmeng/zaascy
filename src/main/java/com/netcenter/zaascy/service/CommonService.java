package com.netcenter.zaascy.service;

import com.netcenter.zaascy.bean.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */
public interface CommonService {
    List<Depart> getDepartList();

    List<Depart> getInstituteList();

    List<TradeResource> getResourceByType(String type);

    String getDepartNumBydepartId(Integer departId);

    boolean valiDatePassword(String username, String password);

    boolean valiDateUsername(String username);

    User getUser(String username, String password);

    String getSubmitorsByModuleId(int moudleId);

    String getAssessorsByModuleId(int moudleId);

    List<RoleRelationKey> getRelosByUserId(Long userId);

    List<Privilege> getPrivilegeByUserIdAndModuleId(Long userId, int moduleId);

    String getDepartFullNameById(Integer departId);

    List<String> getProjectTypeList();
}

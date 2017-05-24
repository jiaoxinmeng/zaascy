package com.netcenter.zaascy.service.impl;

import com.netcenter.zaascy.bean.*;
import com.netcenter.zaascy.dao.*;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.util.SecurityUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/3/20.
 */
@Service(value = "commonService")
public class CommonServiceImpl implements CommonService{

    @Resource(name="departDao")
    private DepartMapper departDao;

    @Resource(name = "tradeResourceDao")
    private TradeResourceMapper resourceDao;

    @Resource(name = "userDao")
    private UserMapper userDao;

    @Resource(name="moduleDao")
    private ModuleMapper moduleDao;

    @Resource(name="roleRelationDao")
    private RoleRelationMapper roleRelationDao;

    @Resource(name="privilegeDao")
    private PrivilegeMapper privilegeDao;

    public List<Depart> getDepartList() {
        return departDao.getAll();
    }

    public List<Depart> getInstituteList(){return departDao.getAllInstitute();}

    public List<TradeResource> getResourceByType(String type){
        return resourceDao.selectByType(type);
    }

    public String getDepartNumBydepartId(Integer departId) {
        return departDao.getDepartNumById(departId);
    }

    public boolean valiDatePassword(String username, String password) {
        String password_db = userDao.findPasswordByLoginname(username);
        try {
            if(password_db!=null&&password_db.equals(SecurityUtil.encryptMessage(password))){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean valiDateUsername(String username) {
        String password_db = userDao.findPasswordByLoginname(username);
        if(password_db!=null){
            return  true;
        }
        return false;
    }

    public User getUser(String username, String password) {
        try {
            return userDao.getUserByUsername(username,SecurityUtil.encryptMessage(password));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getSubmitorsByModuleId(int moduleId) {
        return moduleDao.getSubmitors(moduleId);
    }

    public String getAssessorsByModuleId(int moduleId) {
        return moduleDao.getAssessors(moduleId);
    }

    public List<RoleRelationKey> getRelosByUserId(Long userId) {
        return roleRelationDao.getRelosByUserId(userId);
    }

    public List<Privilege> getPrivilegeByUserIdAndModuleId(Long userId, int moduleId) {
        return privilegeDao.getPrivilege(userId,moduleId);
    }

    public String getDepartFullNameById(Integer departId) {
        return departDao.getDepartFullNameById(departId);
    }

    public List<String> getProjectTypeList() {
        return resourceDao.getProjectTypeList();
    }
}

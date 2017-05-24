package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Privilege;
import com.netcenter.zaascy.bean.RoleRelationKey;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/5/4.
 */
public class PrivilegeController {

    @Resource(name = "commonService")
    private CommonService commonService;

    //全院查看权
    protected Boolean viewEnable = Boolean.FALSE;
    //本单位查看权
    protected Boolean departViewEnable = Boolean.FALSE;
    //全院编辑权
    protected Boolean editEnable = Boolean.FALSE;
    //本单位编辑权
    protected Boolean departEditEnable = Boolean.FALSE;
    //提交者权限
    protected Boolean isSubmitor = Boolean.FALSE;
    //审核者权限
    protected Boolean isAssessor = Boolean.FALSE;
    //本所权限所ID
    protected Long adminDepartId;

    //科技成果转化模块ID
    private final static int moduleId = 720;

//    public boolean hasPermission(HttpSession session){
//        //获取session中登录者信息
//        User user = (User)session.getAttribute("user");
//        if(user==null){
//            return false;
//        }
//
//        //查询角色权限 1.如果是系统管理员权限 则直接拥有全院查看、编辑、提交、审核权限并跳过后续判断 2.如果是院领导 则拥有全院查看权限  继续后续判断  3.其他角色   继续后续判断
//        List<RoleRelationKey> roleRelationKeys = commonService.getRelosByUserId(user.getYonghId());
//        if(roleRelationKeys!=null && roleRelationKeys.size()>1){
//            for (RoleRelationKey relo : roleRelationKeys){
//                if(relo.getJuesId()==33){
//                    editEnable = Boolean.TRUE;
//                    isSubmitor = Boolean.TRUE;
//                    isAssessor = Boolean.TRUE;
//                    return true;
//                }else if(relo.getJuesId()==1){
//                    viewEnable = Boolean.TRUE;
//                }
//            }
//        }
//
//        //查询审核流程权限 1.如果是审核者  直接拥有全院查看、编辑、提交、审核权限并跳过后续判断 2.如果是提交者 本所查看提交 继续后续判断  3.都不是 继续后续判断
//        String assessors = commonService.getAssessorsByModuleId(moduleId);
//        if(assessors!=null && assessors.contains((user.getRenyId()).toString())){
//            isAssessor = Boolean.TRUE;
//            viewEnable = Boolean.TRUE;
//            editEnable = Boolean.TRUE;
//            return true;
//        }
//
//        String submitors = commonService.getSubmitorsByModuleId(moduleId);
//        if(submitors!=null && submitors.contains(user.getRenyId().toString())){
//            isSubmitor = Boolean.TRUE;
//            departViewEnable = Boolean.TRUE;
//            departEditEnable = Boolean.TRUE;
//        }
//
//
//
//        //查询具体权限 1.60 Y 全院编辑、查看  跳过后续判断 2. 60 N 全院查看  继续判断是否有其他权限记录 3.40 Y 本所查看、编辑  继续判断是否有其他权限记录 4.40 N 本所查看  继续判断是否有其他权限记录
//        List<Privilege> privileges = commonService.getPrivilegeByUserIdAndModuleId(user.getYonghId(),moduleId);
//        if(privileges!=null && privileges.size()>1){
//            for(Privilege privilege : privileges){
//                if(privilege.getJuesjb()==60 && privilege.getShifkxg()=="Y"){
//                    viewEnable = Boolean.TRUE;
//                    editEnable = Boolean.TRUE;
//                    return true;
//                }else if (privilege.getJuesjb()==60 && privilege.getShifkxg()=="N"){
//                    viewEnable = Boolean.TRUE;
//                }else if(privilege.getJuesjb()==40 && privilege.getShifkxg()=="Y"){
//                    adminDepartId = user.getDanwId();
//                    departEditEnable = Boolean.TRUE;
//                    departViewEnable = Boolean.TRUE;
//                }else if(privilege.getJuesjb()==40 && privilege.getShifkxg()=="N"){
//                    adminDepartId = user.getDanwId();
//                    departViewEnable = Boolean.TRUE;
//                }
//            }
//            return true;
//        }
//
//        //1.全院或本所任意拥有一种权限则通过  2.什么都没有  呵呵
//        if(viewEnable||editEnable||departEditEnable||departViewEnable){
//            return true;
//        }else{
//            return false;
//        }
//    }
}

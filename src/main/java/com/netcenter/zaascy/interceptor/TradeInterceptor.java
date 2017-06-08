package com.netcenter.zaascy.interceptor;

import com.netcenter.zaascy.bean.Privilege;
import com.netcenter.zaascy.bean.RoleRelationKey;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import org.omg.CORBA.NO_PERMISSION;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/5/5.
 */
public class TradeInterceptor extends BaseInterceptor {

    @Resource(name = "commonService")
    private CommonService commonService;
    @Resource(name = "tradeService")
    private TradeService tradeService;


    //全院查看权标识符
    private Boolean viewEnable = Boolean.FALSE;
    //本单位查看权标识符
    private Boolean departViewEnable = Boolean.FALSE;
    //全院编辑权标识符
    private Boolean editEnable = Boolean.FALSE;
    //本单位编辑权标识符
    private Boolean departEditEnable = Boolean.FALSE;
    //提交者权限标识符
    private Boolean isSubmitor = Boolean.FALSE;
    //审核者权限标识符
    private Boolean isAssessor = Boolean.FALSE;
    //本所权限标识符所ID
    private Long adminDepartId = new Long(0);
    //本人权限标识符
    private Integer projectCount = 0;

    //科技成果转化模块ID
    private final static int moduleId = 720;

    private final static String NO_PERMISSION = "/user/noPermission.do";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(true);

        //获取session中登录者信息
        User user = (User)session.getAttribute("user");
        if(user==null){
            return false;
        }
        //初始化
        viewEnable = Boolean.FALSE;
        departViewEnable = Boolean.FALSE;
        editEnable = Boolean.FALSE;
        departEditEnable = Boolean.FALSE;
        isSubmitor = Boolean.FALSE;
        isAssessor = Boolean.FALSE;
        adminDepartId = 0L;
        projectCount = 0;
        //System.out.println("第一步----"+viewEnable+"-"+departViewEnable+"-"+editEnable+"-"+departEditEnable+"-"+isSubmitor+"-"+isAssessor+"-"+adminDepartId);

        if(!hasPermission(user)){
            response.sendRedirect(NO_PERMISSION);
        }

        String url = request.getRequestURI();
        System.out.println(url);

        if(url.contains("edit")||url.contains("del")||url.contains("save")){
            if(!(editEnable || (departEditEnable && adminDepartId!=0L))){
                response.sendRedirect(NO_PERMISSION);
            }
        }else if(url.contains("submit")){
            if(!isSubmitor){
                response.sendRedirect(NO_PERMISSION);
            }
        }else if(url.contains("access")||url.contains("noAccess")||url.contains("back")){
            if(!isAssessor){
                response.sendRedirect(NO_PERMISSION);
            }
        }else{
            if(!(viewEnable || (departViewEnable && adminDepartId!=0L) || projectCount>0)){
                response.sendRedirect(NO_PERMISSION);
            }
        }


        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(request!=null && request.getRequestURL().toString().contains("trade/list")){

        }
        if(modelAndView!=null){
            modelAndView.addObject("viewEnable",viewEnable);
            modelAndView.addObject("departViewEnable",departViewEnable);
            modelAndView.addObject("editEnable",editEnable);
            modelAndView.addObject("departEditEnable",departEditEnable);
            modelAndView.addObject("isSubmitor",isSubmitor);
            modelAndView.addObject("isAssessor",isAssessor);
            modelAndView.addObject("adminDepartId",adminDepartId);
        }
        //System.out.println(viewEnable+"-"+departViewEnable+"-"+editEnable+"-"+departEditEnable+"-"+isSubmitor+"-"+isAssessor+"-"+adminDepartId);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }

    public boolean hasPermission(User user){



        //查询角色权限 1.如果是系统管理员权限 则直接拥有全院查看、编辑、提交、审核权限并跳过后续判断 2.如果是院领导 则拥有全院查看权限  继续后续判断  3.其他角色   继续后续判断
        List<RoleRelationKey> roleRelationKeys = commonService.getRelosByUserId(user.getYonghId());
        if(roleRelationKeys!=null && roleRelationKeys.size()>0){
            for (RoleRelationKey relo : roleRelationKeys){
                System.out.println("查询到的角色ID为："+relo.getJuesId());
                if(relo.getJuesId()==33){
                    System.out.println("此用户是系统管理员");
                    editEnable = Boolean.TRUE;
                    isSubmitor = Boolean.TRUE;
                    isAssessor = Boolean.TRUE;
                    viewEnable = Boolean.TRUE;
//                    departEditEnable = Boolean.TRUE;
//                    departViewEnable = Boolean.TRUE;
                    return true;
                }else if(relo.getJuesId()==1){
                    System.out.println("此用户是院领导");
                    viewEnable = Boolean.TRUE;
//                    departViewEnable = Boolean.TRUE;
                }
            }
        }else{
            System.out.println("未查询到符合的角色信息");
        }

        //查询审核流程权限 1.如果是审核者  直接拥有全院查看、编辑、提交、审核权限并跳过后续判断 2.如果是提交者 本所查看提交 继续后续判断  3.都不是 继续后续判断
        String assessors = commonService.getAssessorsByModuleId(moduleId);
        if(user.getRenyId()!=null&&assessors!=null && assessors.contains((user.getRenyId()).toString())){
            System.out.println("此用户是审核者");
            isAssessor = Boolean.TRUE;
            viewEnable = Boolean.TRUE;
            editEnable = Boolean.TRUE;
//            departEditEnable = Boolean.TRUE;
//            departViewEnable = Boolean.TRUE;
            return true;
        }

        String submitors = commonService.getSubmitorsByModuleId(moduleId);
        if(user.getRenyId()!=null&&submitors!=null && submitors.contains(user.getRenyId().toString())){
            System.out.println("此用户是提交者");
            isSubmitor = Boolean.TRUE;
            departViewEnable = Boolean.TRUE;
            departEditEnable = Boolean.TRUE;
            adminDepartId = user.getDanwId();
        }



        //查询具体权限 1.60 Y 全院编辑、查看  跳过后续判断 2. 60 N 全院查看  继续判断是否有其他权限记录 3.40 Y 本所查看、编辑  继续判断是否有其他权限记录 4.40 N 本所查看  继续判断是否有其他权限记录
        List<Privilege> privileges = commonService.getPrivilegeByUserIdAndModuleId(user.getYonghId(),moduleId);
        if(privileges!=null && privileges.size()>0){
            for(Privilege privilege : privileges){
                if(privilege.getJuesjb()==60 && privilege.getShifkxg()=="Y"){
                    viewEnable = Boolean.TRUE;
                    editEnable = Boolean.TRUE;
                    return true;
                }else if (privilege.getJuesjb()==60 && privilege.getShifkxg()=="N"){
                    viewEnable = Boolean.TRUE;
                }else if(privilege.getJuesjb()==40 && privilege.getShifkxg()=="Y"){
                    adminDepartId = user.getDanwId();
                    departEditEnable = Boolean.TRUE;
                    departViewEnable = Boolean.TRUE;
                }else if(privilege.getJuesjb()==40 && privilege.getShifkxg()=="N"){
                    adminDepartId = user.getDanwId();
                    departViewEnable = Boolean.TRUE;
                }
            }
            return true;
        }

        //1.全院或本所任意拥有一种权限则通过  2.什么都没有  判断是否是项目参与者
        if(viewEnable||editEnable||departEditEnable||departViewEnable){
            return true;
        }else{
            Integer count = tradeService.getProjectCountByUserId(user.getYonghId());
            System.out.println("查询到本人有"+count+"条记录");
            if(count!=null && count>0){
                projectCount = count;
                return true;
            }
            return false;
        }
    }
}

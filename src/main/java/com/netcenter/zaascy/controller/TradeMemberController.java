package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.*;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.operations.Mod;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2017/5/17.
 */
@Controller
@RequestMapping(value = "/member")
public class TradeMemberController {

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "commonService")
    private CommonService commonService;

    private static Log log = LogFactory.getLog(TradeController.class);

    @RequestMapping(value = "/list")
    public ModelAndView list(Long projectId ,String codeType){
        ModelAndView mav = new ModelAndView();
        List<TradeMember> list = tradeService.getMembers(projectId);

        Trade trade = tradeService.selectByPrimaryKey(projectId);
        if((codeType==null||codeType.equals(""))&&trade!=null){
            codeType = trade.getProjectTypeCode();
        }

        if(trade!=null){
            mav.addObject("projectName",trade.getProjectName());
            mav.addObject("projectNum",trade.getProjectNum());
            mav.addObject("projectDepartId",trade.getDepartId());
            mav.addObject("projectSubmitState",trade.getSubmitState());
        }

        mav.addObject("list",list);
        mav.addObject("projectId",projectId);
        mav.addObject("codeType",codeType);
        mav.setViewName("member_list");
        return mav;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(Long id,Long projectId){
        ModelAndView mav = new ModelAndView();
        TradeMember member = tradeService.getMemberById(id);
        List<Depart> departList = commonService.getDepartList();
        Trade trade  = tradeService.selectByPrimaryKey(projectId);
        if(trade!=null){
            mav.addObject("projectNum",trade.getProjectNum());
            mav.addObject("projectName",trade.getProjectName());
            mav.addObject("projectDepartId",trade.getDepartId());
        }

        mav.addObject("projectId",projectId);
        mav.addObject("member",member);
        mav.addObject("departList",departList);
        mav.setViewName("member_edit");
        return mav;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(TradeMember member,RedirectAttributes attr,HttpSession session){
        ModelAndView mav = new ModelAndView();
        User user = (User)session.getAttribute("user");

        if(member!=null && user!=null){
            tradeService.saveTradeMember(member,user.getYonghId(),user.getXingm());
        }
        attr.addAttribute("projectId",member.getProjectId());
        mav.setViewName("redirect:/member/list.do");
        return mav;
    }

    @RequestMapping(value = "/del")
    public ModelAndView del(Long id,Long projectId,RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        tradeService.delMemberById(id);
        attr.addAttribute("projectId",projectId);
        mav.setViewName("redirect:/member/list.do");
        return mav;
    }

    @RequestMapping(value = "/getPersonList")
    @ResponseBody
    public String getPersonListBydepartId(Long departId,Integer isStaff){
        JSONObject result = new JSONObject();
        try {
            if(departId==null && isStaff==null){
                result.put("stateCode",0);
                result.put("error","参数为空");
            }else if(isStaff==1){
                List<String> staffList = commonService.getUsers(departId);
                result.put("stateCode",1);
                result.put("staffList",staffList);
            }else{
                result.put("stateCode",2);
                //博士后
                List<String> doctorList = commonService.getUsers(departId,2);
                result.put("doctorCount",doctorList.size());
                result.put("doctorList",doctorList);
                //派遣
                List<String> dispatchList = commonService.getUsers(departId,3);
                result.put("dispatchCount",dispatchList.size());
                result.put("dispatchList",dispatchList);
                //一导研究生
                List<String> studentList = commonService.getUsers(departId,4);
                result.put("studentCount",studentList.size());
                result.put("studentList",studentList);
                //其他人员
                List<String> otherPersonList = commonService.getUsers(departId,5);
                result.put("otherPersonCount",otherPersonList.size());
                result.put("otherPersonList",otherPersonList);
                //离休干部
                //List<String> retiredCardeList = commonService.getUsers(departId,8);
                //result.put("doctorList",doctorList);
                //退休职工
                List<String> retiredStaffList = commonService.getUsers(departId,9);
                result.put("retiredStaffCount",retiredStaffList.size());
                result.put("retiredStaffList",retiredStaffList);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

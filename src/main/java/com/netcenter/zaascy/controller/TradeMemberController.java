package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Depart;
import com.netcenter.zaascy.bean.TradeMember;
import com.netcenter.zaascy.bean.TradeResource;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xpath.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    public ModelAndView list(Long projectId){
        ModelAndView mav = new ModelAndView();
        List<TradeMember> list = tradeService.getMembers(projectId);
        mav.addObject("list",list);
        mav.setViewName("member_list");
        return mav;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(Long id){
        ModelAndView mav = new ModelAndView();
        TradeMember member = tradeService.getMemberById(id);
        mav.addObject("member",member);
        mav.setViewName("member_edit");
        return mav;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(TradeMember member){
        ModelAndView mav = new ModelAndView();
        if(member!=null){
            tradeService.saveTradeMember(member);
        }
        return mav;
    }

    @RequestMapping(value = "/del")
    public ModelAndView del(Long id){
        ModelAndView mav = new ModelAndView();
        tradeService.delMemberById(id);
        mav.setViewName("member_edit");
        return mav;
    }
}

package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeFunds;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller
@RequestMapping("/funds")
public class TradeFundsController {

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "commonService")
    private CommonService commonService;

    @RequestMapping(value = "/list")
    public ModelAndView list(Long projectId,String codeType){
        ModelAndView mav = new ModelAndView();
        List<TradeFunds> fundsList = new ArrayList<TradeFunds>();
        if(projectId!=null){
            fundsList = tradeService.getFunds(projectId);
        }
        Trade trade = tradeService.selectByPrimaryKey(projectId);
        if((codeType==null||codeType.equals(""))&&trade!=null){
            codeType = trade.getProjectTypeCode();
        }
        if(trade!=null){
            mav.addObject("projectName",trade.getProjectName());
            mav.addObject("projectNum",trade.getProjectNum());
            mav.addObject("projectDepartId",trade.getDepartId());
        }
        mav.addObject("projectId",projectId);
        mav.addObject("codeType",codeType);
        mav.addObject("fundsList",fundsList);
        mav.setViewName("funds_list");
        return mav;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(Long id,Long projectId,String codeType){
        ModelAndView mav = new ModelAndView();
        TradeFunds funds = new TradeFunds();
        if(id!=null){
            funds = tradeService.getFundsById(id);
        }
        Trade trade  = tradeService.selectByPrimaryKey(projectId);
        if(trade!=null){
            mav.addObject("projectNum",trade.getProjectNum());
            mav.addObject("projectName",trade.getProjectName());
            mav.addObject("customerDepart",trade.getCustomerDepart());
        }
        mav.addObject("projectId",projectId);
        mav.addObject("codeType",codeType);
        mav.addObject("funds",funds);
        mav.setViewName("funds_edit");
        return mav;
    }

    @RequestMapping(value = "/del")
    public ModelAndView del(Long id,Long projectId, RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        if(id!=null){
            tradeService.delFundsById(id);
        }
        attr.addAttribute("projectId",projectId);
        mav.setViewName("redirect:/funds/list.do");
        return mav;
    }

    @RequestMapping(value = "/save")
    public ModelAndView save(TradeFunds funds, RedirectAttributes attr, HttpSession session){
        ModelAndView mav = new ModelAndView();
        Long projectId = new Long(0);
        User user = (User)session.getAttribute("user");

        if(funds!=null && user!=null){
            tradeService.saveFunds(funds,user.getYonghId(),user.getXingm());
            projectId = funds.getProjectId();
        }
        attr.addAttribute("projectId",projectId);
        mav.setViewName("redirect:/funds/list.do");
        return mav;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));   //true:允许输入空值，
    }
}

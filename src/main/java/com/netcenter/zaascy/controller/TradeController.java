package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.service.TradeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.io.File;
import java.util.List;

/**
 * Created by Administrator on 2017/3/31.
 */
@Controller
@RequestMapping(value = "/trade")
public class TradeController {

    @Resource(name = "tradeService")
    private TradeService tradeService;

    private static Log log = LogFactory.getLog(ViewController.class);

    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        List<Trade> tradeList = tradeService.selectAll();
        mav.addObject("tradeList",tradeList);
        mav.setViewName("trade_list");
        return mav;
    }

    public ModelAndView edit(Long id){
        ModelAndView mav = new ModelAndView();
        Trade trade = tradeService.selectByPrimaryKey(id);
        mav.addObject("trade",trade);
        mav.setViewName("trade_edit");
        return mav;
    }

    public ModelAndView save(Trade trade, RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        if(trade==null){
            log.error("TradeController-->save-->trade is null");
        }
        tradeService.insertSelective(trade);
        attr.addAttribute("id",trade.getId());
        mav.setViewName("redirect:/trade/list.do");
        return mav;
    }

    public ModelAndView del(Long id,RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        tradeService.deleteByPrimaryKey(id);
        attr.addAttribute("id",id);
        mav.setViewName("redirect:/trade/list.do");
        return mav;
    }

    public ModelAndView childImport(Integer year, String quarter, String mydata, File myfile, RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();

        return mav;
    }
}

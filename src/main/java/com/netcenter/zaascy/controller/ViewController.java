package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.service.TradeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/3/15.
 */
@Controller
@RequestMapping("/tradeController")
public class ViewController {

    private static Log log = LogFactory.getLog(ViewController.class);
    @Resource(name = "tradeService")
    private TradeService tradeService;

    @RequestMapping(value={"/view"})
    public ModelAndView handleRequest(@RequestParam("test")String test, Trade trade){
        ModelAndView mav = new ModelAndView();
        log.info(test);
        Integer id = tradeService.insertSelective(trade);
        log.info("id为：" + id);
        //这个是返回的id
        Long ids = trade.getId();
        log.info("ids为："+ids);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        map.put("ids",ids);
        mav.addAllObjects(map);
//        mav.addObject("id",id);
//        mav.addObject("ids",ids);
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value={"/edit"})
    public ModelAndView handleRequest(@RequestParam("id")Long id){
        ModelAndView mav = new ModelAndView();
        if(id!=null){
            Trade trade = tradeService.selectByPrimaryKey(id);
            mav.addObject("trade",trade);
        }
        mav.setViewName("trade_edit");
        return mav;
    }

    @RequestMapping(value={"/list"})
    public ModelAndView list(){
        ModelAndView mav = new ModelAndView();
        List<Trade> tradeList = tradeService.selectAll();
        for(Trade trade : tradeList){
            System.out.println(trade.toString());
        }
        Date date = new Date();
        mav.addObject("tradeList",tradeList);
        mav.addObject("date",date);
        mav.setViewName("trade_list");
        return mav;
    }

    @RequestMapping(value={"/del"})
    public ModelAndView del(@RequestParam("test")Long id) {
        ModelAndView mav = new ModelAndView();
        tradeService.deleteByPrimaryKey(id);
        log.info("del success id:" + id);
        mav.setViewName("redirect:/tradeController/list.do");
        return mav;
    }

    @RequestMapping(value={"/detail"})
    public ModelAndView detail(@RequestParam("id")Long id,RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        attr.addAttribute("id",id);
        Trade trade = tradeService.selectByPrimaryKey(id);
        mav.addObject("trade",trade);
        mav.setViewName("trade_detail");
        return mav;
    }

    @RequestMapping(value={"/save"})
    public ModelAndView save(Trade trade,RedirectAttributes attr){
        ModelAndView mav = new ModelAndView();
        tradeService.insertSelective(trade);
        attr.addAttribute("id",trade.getId());
        mav.setViewName("redirect:/tradeController/detail.do");
        return mav;
    }
}

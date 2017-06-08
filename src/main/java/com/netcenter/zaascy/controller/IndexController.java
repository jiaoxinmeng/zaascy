package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.ChartsDemo;
import com.netcenter.zaascy.bean.Depart;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/5/18.
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Resource(name = "commonService")
    private CommonService commonService;

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @RequestMapping
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        List<String> typeList = commonService.getProjectTypeList();
        //首页每类项目个数
        for(String mark :typeList){
            Integer count = tradeService.getTradeCountByType(mark);
            mav.addObject(mark+"_count",count);
        }

        //各研究所统计 得到各研究所记录数
        List<HashMap<String,Integer>> departCountList = tradeService.getCharts("depart",false,"","");
        Map<String,Integer> departCountMap = new HashMap<String, Integer>();
        for(HashMap<String,Integer> map :departCountList){
            System.out.println(map.toString());
            departCountMap.putAll(map);
            System.out.println("---"+departCountMap.toString());
        }
        System.out.println(departCountMap.toString());
        mav.addObject("departCountMap",departCountMap);
        mav.setViewName("index");
        return mav;
    }
}

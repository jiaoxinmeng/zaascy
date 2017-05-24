package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.TradeFunds;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/23.
 */
@Controller
@RequestMapping("/index")
public class TradeFundsController {

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "commonService")
    private CommonService commonService;

    public ModelAndView list(Long projectId){
        ModelAndView mav = new ModelAndView();
        List<TradeFunds> fundsList = new ArrayList<TradeFunds>();
        if(projectId!=null){
            fundsList = tradeService.getFunds(projectId);
        }
        mav.addObject("fundsList",fundsList);
        return mav;
    }

    public ModelAndView edit(Long id){
        ModelAndView mav = new ModelAndView();
        TradeFunds funds = new TradeFunds();
        if(id!=null){
            funds = tradeService.getFundsById(id);
        }
        mav.addObject("funds",funds);
        return mav;
    }

    public ModelAndView del(Long id){
        ModelAndView mav = new ModelAndView();
        if(id!=null){
            tradeService.delFundsById(id);
        }
        return mav;
    }

    public ModelAndView save(TradeFunds funds){
        ModelAndView mav = new ModelAndView();
        if(funds!=null){
            tradeService.saveFunds(funds);
        }
        return mav;
    }
}

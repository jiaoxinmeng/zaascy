package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.TradeSubsidiary;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.TradeService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/5/26.
 */
@Controller
@RequestMapping(value = "/subsidiary")
public class TradeSubsidiaryController {

    @Resource(name = "tradeService")
    private TradeService service;

    @RequestMapping(value = "/save")
    @ResponseBody
    public String save(Long projectId, String zaasTechType, String zaasCode, String zaasTechTitle, HttpSession session){
        JSONObject result = new JSONObject();

        TradeSubsidiary subsidiary = new TradeSubsidiary();
        subsidiary.setProjectId(projectId);
        subsidiary.setZaasTechType(zaasTechType);
        subsidiary.setZaasTechTitle(zaasTechTitle);
        subsidiary.setZaasCode(zaasCode);

        User user = (User)session.getAttribute("user");
        if(user!=null && subsidiary!=null){
            service.saveTradeSubsidiary(subsidiary,user.getYonghId(),user.getXingm());
            try {
                result.put("subsidiaryId", subsidiary.getId());
                result.put("subsidiaryZaasCode", subsidiary.getZaasCode());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return result.toString();
    }

    @RequestMapping(value = "/del")
    @ResponseBody
    public void del(Long id){
        service.delSubsidiaryById(id);

    }
}

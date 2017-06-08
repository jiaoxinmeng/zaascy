package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.Privilege;
import com.netcenter.zaascy.bean.RoleRelationKey;
import com.netcenter.zaascy.bean.Trade;
import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.service.TradeService;
import com.netcenter.zaascy.util.SingleCodeUtil;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/5/27.
 */
@Controller
@RequestMapping(value = "/workFlow")
public class TradeWorkFlowController {

    @Resource(name = "tradeService")
    private TradeService tradeService;

    @Resource(name = "commonService")
    private CommonService commonService;

    private static org.apache.commons.logging.Log log = LogFactory.getLog(TradeWorkFlowController.class);

    //打印审核表、备案表
    @RequestMapping(value = "/printTable")
    public ModelAndView printTable(String tableType, Long id, HttpSession session) {
        ModelAndView mav = new ModelAndView();


        //获取Trade对象
        Trade trade = tradeService.selectByPrimaryKey(id);

        String path = session.getServletContext().getRealPath("singlecode").replace("singlecode", "singlecode/" + trade.getProjectYear() + "/");

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp = sdf.format(date);

        Boolean createSingleCodeImage = SingleCodeUtil.createsingleImg(timeStamp, timeStamp, path);

        if (createSingleCodeImage) {
            //存入数据库
            trade.setOneCode(timeStamp);
            tradeService.updateByPrimaryKeySelective(trade);
        }

        mav.addObject("trade", trade);

        if (tableType != null && tableType.equals("achieveTrans")) {
            mav.setViewName("print_achieve_trans_assessor");
        } else if (tableType.equals("techTrans")) {
            mav.setViewName("print_tech_trans_assessor");
        } else if (tableType.equals("techTransRecord")) {
            mav.setViewName("print_tech_trans_record");
        } else {
            mav.setViewName("../../errors/500");
        }

        return mav;
    }

    @RequestMapping(value = "/printContract")
    public ModelAndView printContract(String codeType, Long id, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();

        //获取Trade对象
        Trade trade = tradeService.selectByPrimaryKey(id);

        response.reset();
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/ms-word");
        String filename = "";
        try {
            if (codeType.equals("Z1")) {
                filename = "技术咨询合同--" + trade.getProjectNum();
            } else if (codeType.equals("K1")) {
                filename = "技术开发(合作)合同--" + trade.getProjectNum();
            } else if(codeType.equals("K2")){
                filename = "技术开发(委托)合同--" + trade.getProjectNum();
            } else if(codeType.equals("F1")){
                filename = "技术服务合同(非检测)--" + trade.getProjectNum();
            } else if(codeType.equals("A4")){
                filename = "技术转让(技术秘密)合同--" + trade.getProjectNum();
            } else if(codeType.equals("A3")){
                filename = "技术转让(专利实施许可)合同--" + trade.getProjectNum();
            } else if(codeType.equals("A2")){
                filename = "技术转让(专利申请权)合同--" + trade.getProjectNum();
            } else if(codeType.equals("A1")){
                filename = "技术转让(专利权)合同--" + trade.getProjectNum();
            }
            response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(filename, "UTF-8") + ".doc");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping(value = "/submit")
    @ResponseBody
    public String doSubmit(Long id, HttpSession session){
        String returnStr = "";
        User user = (User)session.getAttribute("user");
        if(id==null){
            returnStr = "提交失败，ID为空 ";
        }
        if(user!=null){
            tradeService.submit(id,user.getYonghId(),user.getXingm());
            returnStr = "提交成功 ";
        }

        commonService.sendMessageBytype("submit",id);
        //log.info(messageReturn);

//        if(messageReturn.equals("success")){
//            returnStr = returnStr + " 短信提醒成功";
//        }else {
//            returnStr = returnStr + " 短信提醒失败," + messageReturn;
//        }

        JSONObject result = new JSONObject();
        try {
            result.put("msg", returnStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/access")
    @ResponseBody
    public String doAccess(Long id, HttpSession session){
        String returnStr = "";
        User user = (User)session.getAttribute("user");
        if(id==null){
            returnStr = "审核失败，ID为空 ";
        }
        if(user!=null){
            tradeService.access(id,user.getYonghId(),user.getXingm());
            returnStr = "审核成功 ";
        }

        commonService.sendMessageBytype("access",id);
//        log.info(messageReturn);
//
//        if(messageReturn.equals("success")){
//            returnStr = returnStr + " 短信发送成功";
//        }else {
//            returnStr = returnStr + " 短信发送失败," + messageReturn;
//        }

        JSONObject result = new JSONObject();
        try {
            result.put("msg", returnStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/notAccess")
    @ResponseBody
    public String doNotAccess(Long id, HttpSession session){
        String returnStr = "";
        User user = (User)session.getAttribute("user");
        if(id==null){
            returnStr = "解除审核失败，ID为空 ";
        }
        if(user!=null){
            tradeService.notAccess(id,user.getYonghId(),user.getXingm());
            returnStr = "解除审核成功 ";
        }
        JSONObject result = new JSONObject();
        try {
            result.put("msg", returnStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    @RequestMapping(value = "/back")
    @ResponseBody
    public String doBack(Long id, HttpSession session){
        String returnStr = "";
        User user = (User)session.getAttribute("user");
        if(id==null){
            returnStr = "退回失败，ID为空 ";
        }
        if(user!=null){
            tradeService.back(id,user.getYonghId(),user.getXingm());
            returnStr = "退回成功 ";
        }
        commonService.sendMessageBytype("back",id);
//        log.info(messageReturn);
//        System.out.println(messageReturn);
//
//        if(messageReturn.equals("success")){
//            returnStr = returnStr + " 短信发送成功";
//        }else {
//            returnStr = returnStr + " 短信发送失败,错误原因：" + messageReturn;
//        }

        JSONObject result = new JSONObject();
        try {
            result.put("msg", returnStr);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

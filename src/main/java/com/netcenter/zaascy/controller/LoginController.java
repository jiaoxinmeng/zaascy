package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.bean.User;
import com.netcenter.zaascy.service.CommonService;
import com.netcenter.zaascy.util.LoginStub;
import org.apache.axis2.AxisFault;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * Created by Administrator on 2017/3/20.
 */
@Controller
@RequestMapping("/user")
public class LoginController {

    @Resource(name = "commonService")
    private CommonService commonService;

    @RequestMapping(value={"/fastLogin"})
    public ModelAndView login(@RequestParam("token") String token){
        ModelAndView mav = new ModelAndView();
        try {
            LoginStub ls = new LoginStub();
            LoginStub.Login login = new LoginStub.Login();
            login.setToken(token);
            try {
                String result = ls.login(login).get_return();
                if(result.equals("success")){

                    mav.setViewName("redirect:/index.do");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return mav;
    }

    @RequestMapping(value={"/login"})
    public ModelAndView login (String username, String password, HttpSession session){
        ModelAndView mav = new ModelAndView();
        if(username==null||password==null){
            mav.addObject("message","用户名或密码不能为空，请确认后重新输入。");
            mav.setViewName("login");
        }else if(commonService.valiDatePassword(username,password)){
            User user = commonService.getUser(username,password);
            //System.out.println(user.toString());
            session.setAttribute("user",user);
            mav.setViewName("redirect:/index.do");
        }else{
            mav.addObject("message","用户名或密码错误，请确认后重新输入。");
            mav.setViewName("login");
        }
        return mav;
    }

    @RequestMapping(value={"/loginOut"})
    public ModelAndView loginOut (HttpSession session){
        ModelAndView mav = new ModelAndView();
        Enumeration attributeNames = session.getAttributeNames();
        while(attributeNames.hasMoreElements()){
            String attrName = attributeNames.nextElement().toString();
            session.setAttribute(attrName, null);
            session.removeAttribute(attrName);
        }
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value={"/goLogin"})
    public ModelAndView goLogin(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }

    @RequestMapping(value={"/noPermission"})
    public ModelAndView noPermission(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("errors/no_permission");
        return mav;
    }

    @RequestMapping(value={"/index"})
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();

        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/valiUsername")
    @ResponseBody
    public String valiUsername(String username){
        JSONObject result = new JSONObject();
        try {
            if(username!=null&&commonService.valiDateUsername(username)){
                result.put("code",true);
            }else{
                result.put("code",false);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}

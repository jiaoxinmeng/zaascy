package com.netcenter.zaascy.controller;

import com.netcenter.zaascy.util.LoginStub;
import org.apache.axis2.AxisFault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.rmi.RemoteException;

/**
 * Created by Administrator on 2017/3/20.
 */
@Controller
@RequestMapping("/userController")
public class LoginController {

    @RequestMapping(value={"/login"})
    public ModelAndView login(@RequestParam("token") String token){
        ModelAndView mav = new ModelAndView();
        try {
            LoginStub ls = new LoginStub();
            LoginStub.Login login = new LoginStub.Login();
            login.setToken(token);
            try {
                String result = ls.login(login).get_return();
                if(result.equals("success")){
                    mav.setViewName("index");
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        } catch (AxisFault axisFault) {
            axisFault.printStackTrace();
        }
        return mav;
    }

}

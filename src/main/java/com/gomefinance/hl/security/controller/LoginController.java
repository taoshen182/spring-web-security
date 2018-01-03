package com.gomefinance.hl.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author hzj
 * @Date 2017/5/8 13:58
 * @Description :
 */
@Controller
@RequestMapping(value = "/user")
public class LoginController {

    private static String LOGIN = "login";

    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView login(ModelMap model, HttpServletRequest request) {



        return new ModelAndView("redirect:/login.jsp",  model);
    }


}

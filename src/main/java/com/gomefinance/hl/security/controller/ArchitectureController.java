package com.gomefinance.hl.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author hzj
 * @Date 2017/6/21 22:05
 * @Description :
 */
@Controller
@RequestMapping(value = "/architecture")
public class ArchitectureController {


    @RequestMapping(value = "/distribute")
    public ModelAndView distribute(ModelMap model){

        return new ModelAndView("",model) ;
    }


}

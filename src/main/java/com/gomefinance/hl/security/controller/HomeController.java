package com.gomefinance.hl.security.controller;

import com.gomefinance.hl.security.model.MenuDO;
import com.gomefinance.hl.security.service.impl.MenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/12 14:00
 * @Description :
 */
@Controller
@RequestMapping(value = "/security")
public class HomeController {

    private static final Logger log = LoggerFactory.getLogger(HomeController.class);

    private static String HOME = "home";

    @Autowired
    private MenuServiceImpl menuService;


    @RequestMapping(value = "/home",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(ModelMap model) throws Exception{
        try{
            List<MenuDO> menuList = menuService.listMenuDO();

            model.put("menuList",menuList);
        }catch (Exception e ){
            log.error(e.getMessage(),e);
            throw  e;
        }

        return new ModelAndView(HOME,model);
    }


}

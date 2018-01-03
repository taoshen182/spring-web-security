package com.gomefinance.hl.security.controller;

import com.gomefinance.hl.security.model.MenuDO;
import com.gomefinance.hl.security.service.impl.MenuServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/20 17:01
 * @Description :
 */
@Controller
@RequestMapping(value = "/menu")
public class MenuListController {

    private static final Logger log = LoggerFactory.getLogger(MenuListController.class);

    @Autowired
    private MenuServiceImpl menuService;

    @ResponseBody
    @RequestMapping(value = "list")
    public List<MenuDO> getMenuList() throws Exception{
        try {

            List<MenuDO> menuDoList = menuService.listMenuDO();

            return menuDoList;
        }catch (Exception e){
            log.error("获取当前用户菜单权限列表异常",e);
            throw  e;
        }
    }

}

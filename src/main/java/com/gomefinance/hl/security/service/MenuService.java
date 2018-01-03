package com.gomefinance.hl.security.service;

import com.gomefinance.hl.security.model.MenuDO;

import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/20 17:46
 * @Description :
 */

public interface MenuService {

    /**
     * 通过角色结合获取 ， 拥有的菜单权限
     *
     * @return
     */
    List<MenuDO> listMenuDO() throws Exception;

}

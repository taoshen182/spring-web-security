package com.gomefinance.hl.security.service.impl;

import com.gomefinance.hl.security.mapper.MenuMapper;
import com.gomefinance.hl.security.model.MenuDO;
import com.gomefinance.hl.security.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author hzj
 * @Date 2017/6/20 17:46
 * @Description :
 */
@Service
public class MenuServiceImpl implements MenuService {

    private static final Logger log = LoggerFactory.getLogger(MenuServiceImpl.class);

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuDO> listMenuDO() throws Exception{


        try {
            // 获取当前用户的权限  即： 角色列表
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            //如果当前的Authentication对象为空 ，说明当前用户未登录  抛出异常
            if (authentication == null) {
                throw new AuthenticationCredentialsNotFoundException("getMenuList fail , the current Authentication is null");
            }
            Collection<GrantedAuthority> collection = (Collection<GrantedAuthority>) authentication.getAuthorities();

            List<MenuDO> menuList = menuMapper.listMenuDOByRoleList(collection);

            if (menuList == null || menuList.isEmpty()) return menuList;

            return getMenuListTree(menuList);
        } catch (AuthenticationCredentialsNotFoundException e) {
            log.error(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            log.error("获取当前用户菜单权限列表异常", e);
            throw e;
        }
    }


    private List<MenuDO> getMenuListTree(List<MenuDO> menuList) {


        Map<Integer, MenuDO> menuMap = new TreeMap<Integer, MenuDO>();

        //去除菜单的父子关系，把菜单放于Map中储存
        for (MenuDO menu1 : menuList) {
            if (menu1.getChildren() != null && !menu1.getChildren().isEmpty()) {
                menu1.getChildren().clear();
            }
            menuMap.put(menu1.getMenuId(), menu1);
        }

//        List<MenuDO> list = new ArrayList<MenuDO>();
//        for (Map.Entry<Integer, MenuDO> e : menuMap.entrySet()) {
//            MenuDO me = e.getValue();
//            if(me.getMenuLevel()== null || me.getMenuLevel() == "") continue;
//            list.add(e.getValue());
//        }
//        //把菜单按照级别排序
//        Collections.sort(list, new Comparator<MenuDO>(){
//
//            @Override
//            public int compare(MenuDO o1, MenuDO o2) {
//                return o1.getMenuLevel().compareTo(o2.getMenuLevel());
//            }
//
//        });

        //在父菜单中添加子菜单
        for (MenuDO m : menuList) {

            MenuDO n = menuMap.get(m.getMenuId());

            // 菜单没有parentId 表示该URL接受为REST 接口
            if (n.getMenuParentId() == null){
                menuMap.remove(n.getMenuId());
                continue;
            }

            if (menuMap.containsKey(n.getMenuParentId())) {
                MenuDO parent = menuMap.get(n.getMenuParentId());
                parent.getChildren().add(n);
            }
        }
        //返回顶级顶级目录
        List<MenuDO> topMenuList = new ArrayList<MenuDO>();
        for (Map.Entry<Integer, MenuDO> e : menuMap.entrySet()) {

            if (e.getValue().getMenuParentId() == 0) {
                topMenuList.add(e.getValue());
            }
        }

        return topMenuList;

    }


}

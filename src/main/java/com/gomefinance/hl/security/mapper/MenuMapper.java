package com.gomefinance.hl.security.mapper;

import com.gomefinance.hl.security.common.BaseMapper;
import com.gomefinance.hl.security.model.MenuDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/14 14:35
 * @Description :
 */
public interface MenuMapper extends BaseMapper<MenuDO> {

    /**
     * 加载当前资源权限列表
     *
     * @return
     */
    @Select("select mu.menu_id as menuId, mu.menu_resc_str as menuRescStr , mu.menu_level as menuLevel , mu.menu_parent_id as menuParent, mu.menu_type as menuType,  mu.menu_name as menuName , ro.role_name as roleName from role_menu rm INNER JOIN role ro on rm.role_id = ro.role_id LEFT JOIN menu mu on rm.menu_id = mu.menu_id ")
    List<MenuDO> listMenuDO();

    @SelectProvider(type = MenuDOProvider.class, method = "listMenuDOByRoleList")
    List<MenuDO> listMenuDOByRoleList(@Param(value = "roleList") Collection<GrantedAuthority> roleList);

}

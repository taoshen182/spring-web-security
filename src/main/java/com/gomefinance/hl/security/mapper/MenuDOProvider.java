package com.gomefinance.hl.security.mapper;

import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @Author hzj
 * @Date 2017/6/20 17:57
 * @Description :
 */
public class MenuDOProvider {


    private static final String SELECT_ROLE_MENU_LIST = "select mu.menu_id as menuId, mu.menu_resc_str as menuRescStr , mu.menu_level as menuLevel , mu.menu_parent_id as menuParentId, mu.menu_type as menuType,  mu.menu_name as menuName , ro.role_name as roleName from role_menu rm INNER JOIN role ro on rm.role_id = ro.role_id LEFT JOIN menu mu on rm.menu_id = mu.menu_id where ro.role_name in (%s)";

    private static final Logger log = LoggerFactory.getLogger(MenuDOProvider.class);

    /**
     * 根据role集合 获取惨淡权限集合
     *
     * @param roleList
     * @return
     */
    public String listMenuDOByRoleList(@Param(value = "roleList") Collection<GrantedAuthority> roleList) {

        String sql = new String(SELECT_ROLE_MENU_LIST);

        if (roleList != null && !roleList.isEmpty()) {
            StringBuilder roles = new StringBuilder();
            roleList.stream().forEach(role -> {
                roles.append("'").append(role.getAuthority()).append("',");
            });
            sql = String.format(sql, roles.substring(0, roles.length() - 1).toString());
        }

//        String sql = new SQL().SELECT(ROLE_MENU_LIST).WHERE(condition).toString();

        return sql;
    }


}

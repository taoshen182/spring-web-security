package com.gomefinance.hl.security.model;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @Author hzj
 * @Date 2017/6/14 14:06
 * @Description :
 */
@Table(name = "role_menu")
public class RoleMenuDO implements Serializable{
    @Transient
    private static final long serialVersionUID = 1571505167808462841L;

    private Integer roleId;     //角色ID
    private Integer menuId;     //菜单ID

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}

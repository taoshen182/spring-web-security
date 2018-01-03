package com.gomefinance.hl.security.model;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @Author hzj
 * @Date 2017/6/14 14:04
 * @Description :
 */
@Table(name = "role_user")
public class RoleUserDO implements Serializable{

    @Transient
    private static final long serialVersionUID = 3550776327278345622L;

    private Integer userId; // 用户ID
    private Integer roleId; // 角色ID

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}

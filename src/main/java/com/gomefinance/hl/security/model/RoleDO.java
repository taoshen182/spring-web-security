package com.gomefinance.hl.security.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author hzj
 * @Date 2017/6/14 13:55
 * @Description :
 */
@Table(name = "role")
public class RoleDO implements Serializable {
    @Transient
    private static final long serialVersionUID = 5849698805808952737L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;     //角色ID  唯一标识  自动增长
    private String roleName;    //角色名称
    private String roleDescription;//角色描述
    private String roleStatus; //角色状态（0：停用 | 1：启用）

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }
}

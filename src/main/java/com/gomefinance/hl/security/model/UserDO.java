package com.gomefinance.hl.security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/14 13:44
 * @Description :
 */
@Table(name = "user")
public class UserDO implements Serializable {
    @Transient
    private static final long serialVersionUID = -819110431211429480L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;  // 用户ID 自动增长
    private String userName;  // 用户名
    private String nickname;
    private String password;  // 密码
    private String idType;  // 证件类型
    private String idNo;  // 证件号码
    private String email;  // 邮箱
    private String phone;  // 移动电话号码
    private String userStatus;  // 用户状态（0：停用  | 1 ： 启用）
    private Timestamp createTime;  // 注册时间
    private Timestamp invalidTime;  // 失效日期
    @Transient
    private List<RoleDO> roleList;  //用户拥有的角色

    public List<RoleDO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleDO> roleList) {
        this.roleList = roleList;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getInvalidTime() {
        return invalidTime;
    }

    public void setInvalidTime(Timestamp invalidTime) {
        this.invalidTime = invalidTime;
    }
}
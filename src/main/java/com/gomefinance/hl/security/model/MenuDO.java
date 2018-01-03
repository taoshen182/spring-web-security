package com.gomefinance.hl.security.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/14 13:58
 * @Description :
 */
@Table(name = "menu")
public class MenuDO implements Serializable {
    @Transient
    private static final long serialVersionUID = 1351875740601649828L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer menuId;     //菜单唯一标识（自动增长）
    private String menuName;    //菜单名称
    private Integer menuParentId;//当前菜单父菜单ID
    private String menuRescStr; //菜单对应的路径资源
    private String menuType;    //菜单类型
    private String menuDescription;//菜单描述
    private String menuLevel;    // 菜单等级
    private String menuStatus;  //菜单状态
    @Transient
    private String roleName;    //菜单拥有的角色
    @Transient
    private List<MenuDO> children = new ArrayList<MenuDO>();

    public List<MenuDO> getChildren() {
        return children;
    }

    public void setChildren(List<MenuDO> children) {
        this.children = children;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuParentId() {
        return menuParentId;
    }

    public void setMenuParentId(Integer menuParentId) {
        this.menuParentId = menuParentId;
    }

    public String getMenuRescStr() {
        return menuRescStr;
    }

    public void setMenuRescStr(String menuRescStr) {
        this.menuRescStr = menuRescStr;
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public String getMenuDescription() {
        return menuDescription;
    }

    public void setMenuDescription(String menuDescription) {
        this.menuDescription = menuDescription;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuStatus() {
        return menuStatus;
    }

    public void setMenuStatus(String menuStatus) {
        this.menuStatus = menuStatus;
    }
}

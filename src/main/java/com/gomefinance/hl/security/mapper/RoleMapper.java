package com.gomefinance.hl.security.mapper;

import com.gomefinance.hl.security.common.BaseMapper;
import com.gomefinance.hl.security.model.RoleDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author hzj
 * @Date 2017/6/14 14:35
 * @Description :
 */
public interface RoleMapper extends BaseMapper<RoleDO> {

    /**
     * 通过用户ID 查询用户所拥有的角色
     *
     * @param userId
     * @return
     */
    @Select("select ro.role_id as roleId, ro.role_name as roleName , ro.role_status as roleStatus, ro.role_description as roleDescription from role ro INNER JOIN role_user ru on ro.role_id = ru.role_id where ru.user_id = #{userId} ")
    List<RoleDO> listRoles(@Param(value = "userId") Integer userId);


}

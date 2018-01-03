package com.gomefinance.hl.security.mapper;

import com.gomefinance.hl.security.common.BaseMapper;
import com.gomefinance.hl.security.model.UserDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author hzj
 * @Date 2017/6/14 14:33
 * @Description :
 */
public interface UserMapper extends BaseMapper<UserDO> {

    /**
     * 根据用户名 或者 手机号查询用户信息
     *
     * @param condition
     * @return
     */
    @Select(" select u.user_id as userId , u.user_name as userName ,u.user_status userStatus , u.id_no as idNo , u.id_type as idType ,u.email , u.`password`, u.phone, u.create_time as createTime , u.invalid_time as invalidTime, u.nickname  from user u where  u.nickname = #{condition} or u.phone = #{condition} ; ")
    UserDO getUserDO(@Param(value = "condition") String condition);

}

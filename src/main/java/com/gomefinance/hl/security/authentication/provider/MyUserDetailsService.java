package com.gomefinance.hl.security.authentication.provider;

import com.gomefinance.hl.security.excepton.BusinessException;
import com.gomefinance.hl.security.mapper.RoleMapper;
import com.gomefinance.hl.security.mapper.UserMapper;
import com.gomefinance.hl.security.model.RoleDO;
import com.gomefinance.hl.security.model.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 根据用户姓名获取用户详情 （用户名、密码、权限信息）
 *
 *
 * @Author hzj
 * @Date 2017/6/19 18:31
 * @Description :
 */
public class MyUserDetailsService implements UserDetailsService{

    private final static Logger log = LoggerFactory.getLogger(MyUserDetailsService.class);
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    boolean enables = true;
    boolean accountNonExpired = true;
    boolean credentialsNonExpired = true;
    boolean accountNonLocked = true;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {

            //  获取用户详细信息
            UserDO userDO = userMapper.getUserDO(username);

            if (userDO == null) {
                log.info("{}：该用户不存在");
                throw new BusinessException("", "登录用户不存在");
            } else {

                // 获取用户的角色信息
                List<RoleDO> userRoleList = roleMapper.listRoles(userDO.getUserId());

                //  获取用户权限信息
                Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(userRoleList);

                // TODO 3、通过认证信息确定用户是否有权登录系统,判断用户密码密码是否匹配

                UserDetails userDetails = new User(username, userDO.getPassword(), enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

                // TODO 4、认证通过后，将当前authenticationToken放入当前上下文

                return userDetails;
            }

        } catch (Exception e) {
            log.error("用户登录认证失败,username={}", username, e);
            throw e;
        }


    }


    /**
     * 获取当前用户所拥有的权限（即：角色）
     *
     * @return
     */
    private Set<GrantedAuthority> obtionGrantedAuthorities(List<RoleDO> list) {
        Set<GrantedAuthority> authSet = new HashSet<GrantedAuthority>();

        // 获取当前用户所拥有的权限
        list.stream().forEach(roleDO -> {
            authSet.add(new SimpleGrantedAuthority(roleDO.getRoleName()));
        });
        //默认权限 - 用户门户页面
//       authSet.add(new SimpleGrantedAuthority(SecurityConstants.ROLE_USER));

        return authSet;
    }

}

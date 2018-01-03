package com.gomefinance.hl.security.authentication.provider;

import com.gomefinance.hl.security.authentication.token.MyAuthenticationToken;
import com.gomefinance.hl.security.excepton.BusinessException;
import com.gomefinance.hl.security.mapper.RoleMapper;
import com.gomefinance.hl.security.mapper.UserMapper;
import com.gomefinance.hl.security.model.RoleDO;
import com.gomefinance.hl.security.model.UserDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author hzj
 * @Date 2017/5/9 15:08
 * @Description :
 */
public class MyAuthenticationProvider implements AuthenticationProvider{

    private final static Logger log = LoggerFactory.getLogger(MyAuthenticationProvider.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;
    /**
     * 用户认证用户身份信息<br/>
     * 1、获取用户页面中认证信息，用户名与密码<br/>
     * 2、从服务器获取当前用户的相关信息（用户名、密码、角色信息、权限信息）<br/>
     * 3、通过认证信息确定用户是否有权登录系统<br/>
     * 4、认证通过后，将当前authenticationToken放入当前上下文<br/>
     *
     * 记录用户会话信息<br/>
     *
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        boolean enables = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        String userName = null;
        String password = null;
        try {
            log.debug("authenticate : 用户登录认证开始");
            MyAuthenticationToken authenticationToken = (MyAuthenticationToken) authentication;

            //1、获取用户输入认证信息，用户名与密码
            userName = (String) authenticationToken.getPrincipal();
            password = (String) authenticationToken.getCredentials();

            // TODO 2、从服务器获取当前用户的先关信息（用户名、密码、角色信息、权限信息）

            //  获取用户详细信息
            UserDO userDO = userMapper.getUserDO(userName);

            if(userDO ==null ){
                log.info("{}：该用户不存在");
                throw new BusinessException("","登录用户不存在");
            }else{

                // 获取用户的角色信息
                List<RoleDO> userRoleList = roleMapper.listRoles(userDO.getUserId());

                //  获取用户权限信息
                Collection<GrantedAuthority> grantedAuths = obtionGrantedAuthorities(userRoleList);

                // TODO 3、通过认证信息确定用户是否有权登录系统,判断用户密码密码是否匹配

                User userDetails = new User(userName, password, enables, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

                // TODO 4、认证通过后，将当前authenticationToken放入当前上下文

                authenticationToken.setDetails(userDetails);

                if (password.equals(userDO.getPassword())) {
                    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
                    return authenticationToken;
                }

            }
            throw new AuthenticationServiceException("用户认证失败");

        } catch (Exception e) {
            log.error("用户登录认证失败,username={}",userName, e);
            throw new AuthenticationServiceException(e.getMessage());
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (MyAuthenticationToken.class.isAssignableFrom(authentication));
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

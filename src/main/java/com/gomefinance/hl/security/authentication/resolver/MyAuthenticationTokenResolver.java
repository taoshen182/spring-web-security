package com.gomefinance.hl.security.authentication.resolver;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
/**
 *
 * 自定义认证解析器，用于解析用户的登录请求信息
 *
 * @Author hzj
 * @Date 2017/5/9 13:47
 * @Description :
 */
public class MyAuthenticationTokenResolver extends AbstractAuthenticationTokenResolver {


    @Override
    public Authentication resolve(HttpServletRequest request) {

//        log.debug("resolve : resolve Authentication info begin ");
//        //获取用户的登录信息
//        String username = request.getParameter(SecurityConstants.USERNAME_KEY);
//        String password = request.getParameter(SecurityConstants.PASSWORD_KEY);
//
//        log.info("resolve : username is {} , password : {}", username , password);
//        // 用户权限集合
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//        // authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//
//        Map<String, String> params = new HashMap<String, String>();
//        String clientIp = request.getRemoteAddr();
//        params.put(SecurityConstants.CLIENT_IP, clientIp);
//        log.info("params ->set clientIp:" + clientIp);
//
//        log.debug("resolve : resolve Authentication info end  ");
//        return new MyAuthenticationToken(username, password, authorities,params);
        return null;
    }
}

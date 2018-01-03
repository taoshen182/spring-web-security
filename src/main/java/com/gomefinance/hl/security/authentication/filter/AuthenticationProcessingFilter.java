package com.gomefinance.hl.security.authentication.filter;

import com.gomefinance.hl.security.authentication.common.SecurityConstants;
import com.gomefinance.hl.security.authentication.token.MyAuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *  登录认证过滤器<br/>
 *  1、获取用户登录认证信息，交给认证管理器处理
 *
 * @Author hzj
 * @Date 2017/5/8 19:36
 * @Description :
 */
public class AuthenticationProcessingFilter extends AbstractAuthenticationProcessingFilter {

    private final static Logger log = LoggerFactory.getLogger(AuthenticationProcessingFilter.class);

    public AuthenticationProcessingFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {

        log.debug(" attemptAuthentication ： 进入用户认证过滤器,解析用户的认证信息 ");

        Authentication authentication = this.resolve(request);

        log.debug(" attemptAuthentication ： 进入用户认证过滤器，解析用户认证信息完毕 ");

        return this.getAuthenticationManager().authenticate(authentication);
    }

    public Authentication resolve(HttpServletRequest request) {
        log.debug("resolve : resolve Authentication info begin ");
        //获取用户的登录信息
        String username = request.getParameter(SecurityConstants.USERNAME_KEY);
        String password = request.getParameter(SecurityConstants.PASSWORD_KEY);

        log.info("resolve : username is {} , password : {}", username , password);
        // 用户权限集合
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        // authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

        Map<String, String> params = new HashMap<String, String>();
        String clientIp = request.getRemoteAddr();
        params.put(SecurityConstants.CLIENT_IP, clientIp);
        log.info("params ->set clientIp:" + clientIp);

        log.debug("resolve : resolve Authentication info end  ");
        return new MyAuthenticationToken(username, password, authorities,params);
    }


}

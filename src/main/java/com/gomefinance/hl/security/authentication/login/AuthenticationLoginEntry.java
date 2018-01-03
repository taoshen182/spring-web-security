package com.gomefinance.hl.security.authentication.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 当用户在没有被授权时，访问了受保护的资源 系统会自动跳转到认证界面
 *
 * @Author hzj
 * @Date 2017/5/9 17:29
 * @Description :
 */
//@Component("authenticationLoginEntry")
public class AuthenticationLoginEntry implements AuthenticationEntryPoint{

   private final static Logger log = LoggerFactory.getLogger(AuthenticationLoginEntry.class);

    /**
     * 当权限认证失败后，调转的url
     */
//    @Value("${security.view.login_url}")
    private String loginUrl;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

        log.debug("sendRedirect loginUrl:" + loginUrl);

        response.sendRedirect(request.getContextPath() + loginUrl);

    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }
}

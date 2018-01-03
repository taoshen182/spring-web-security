package com.gomefinance.hl.security.authentication.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * 用户登录失败的相关处理<br/>
 * <br/>
 * 1、认证失败后，系统将自动跳转到指定的错误页面<br/>
 * 2、此处可以加入用户登录失败的记录信息，根据需要加入相关的逻辑<br/>
 *
 * @Author hzj
 * @Date 2017/5/9 16:05
 * @Description :
 */
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

    private final static Logger log = LoggerFactory.getLogger(AuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {

        // TODO 加入业务的登录失败处理逻辑
        log.info("onAuthenticationFailure ： 登录失败，失败原因：{}",exception.getMessage());
        super.onAuthenticationFailure(request, response, exception);
    }
}

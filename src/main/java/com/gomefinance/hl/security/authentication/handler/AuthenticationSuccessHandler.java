package com.gomefinance.hl.security.authentication.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 *
 * 用户登录成功的相关处理<br/><br/>
 * 1、自动跳转到指定的登录成功的主页<br/>
 * 2、可以加入登录成功的先关处理逻辑（）
 *
 * @Author hzj
 * @Date 2017/5/9 16:18
 * @Description :
 */
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationSuccessHandler.class);


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        if(authentication != null){
            //登录成功   获取登录成功的用户名称
            User userDeatil = (User) authentication.getPrincipal();
            String userName = userDeatil.getUsername();

            //TODO 此处可以加入用户登录成功的先关处理逻辑
            logger.info("onAuthenticationSuccess ： {}登录成功",userName);
        }

        super.onAuthenticationSuccess(request, response, authentication);
    }

}

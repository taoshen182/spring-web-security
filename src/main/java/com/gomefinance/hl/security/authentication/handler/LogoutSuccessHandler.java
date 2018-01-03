package com.gomefinance.hl.security.authentication.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author hzj
 * @Date 2017/6/13 18:48
 * @Description :
 */
public class LogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(LogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        if(authentication != null){
            String userName = authentication.getName();

            //TODO 此处可以加入用户注销成功的相关处理逻辑
            log.info("onLogoutSuccess ： {} 注销成功",userName);
        }
        super.onLogoutSuccess(request, response, authentication);
    }
}

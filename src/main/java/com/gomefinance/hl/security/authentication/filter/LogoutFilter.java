package com.gomefinance.hl.security.authentication.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 *<p> 注销过滤器</p>
 *
 *
 *
 * @Author hzj
 * @Date 2017/6/13 18:08
 * @Description :
 */
public class LogoutFilter extends org.springframework.security.web.authentication.logout.LogoutFilter {

    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);
    public LogoutFilter(LogoutSuccessHandler logoutSuccessHandler, LogoutHandler... handlers) {
        super(logoutSuccessHandler, handlers);
    }

    public LogoutFilter(String logoutSuccessUrl, LogoutHandler... handlers) {
        super(logoutSuccessUrl, handlers);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {



        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        HttpServletRequest request = (HttpServletRequest) req;
        if(requiresLogout(request)){

            //TODO  此处可以加入系统退出时，系统所需要进行的处理逻辑

            log.debug("{} 系统注销成功",userName);
        }else{
            log.info("{} 系统注销失败",userName);
        }

        super.doFilter(req, res, chain);

    }


    /**
     * 请求URI过滤-  登出
     * @param request
     * @return
     */
    private boolean requiresLogout(HttpServletRequest request ){

        String reqLogoutURI = request.getRequestURI().substring(request.getContextPath().length());
//        if(reqLogoutURI.equalsIgnoreCase(super.getFilterProcessesUrl())){
//            return true;
//        }

        return false;

    }

}

package com.gomefinance.hl.security.authentication.resolver;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author hzj
 * @Date 2017/5/8 19:45
 * @Description :
 */

public interface AuthenticationTokenResolver {

    /**
     * 根据自定义的参数，判断登录请求的来源，进行不同的逻辑处理
     *
     * @param request
     * @return
     */
    boolean support(HttpServletRequest request);

    /**
     *
     * 解析登录界面传入的用户认证信息，封装为Authentication 对象返回
     *
     * @param request
     * @return
     */
    Authentication resolve(HttpServletRequest request);

}

package com.gomefinance.hl.security.authentication.resolver;

import com.gomefinance.hl.security.authentication.filter.AuthenticationProcessingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 用于解析登录页面中的自定义标识<br/>
 * 比如：标识系统的前后端登录
 *
 * @Author hzj
 * @Date 2017/5/8 19:48
 */
public abstract class AbstractAuthenticationTokenResolver implements AuthenticationTokenResolver{

    protected final static Logger log = LoggerFactory.getLogger(AuthenticationProcessingFilter.class);

    /**
     *设置登录页面默认的登录名 与 密码 的key值
     */
//    @Value("${security.view.token}")
    protected String parameterName = "token";
//    @Value("${security.view.tokenvalue}")
    protected String parameterValue = "tokenvalue";

    protected AbstractAuthenticationTokenResolver() {
    }

    protected AbstractAuthenticationTokenResolver(String parameterName) {
        this.parameterName = parameterName;
    }

    @Override
    public boolean support(HttpServletRequest request) {

        String parameterValue = request.getParameter(parameterName);
        if (parameterValue == null || "".equals(parameterValue)) {
            log.info("support :　{} is null or '' , Authentication is end !", parameterName);
            return false;
        }
        return parameterValue.equals(this.parameterValue);
    }

    public abstract Authentication resolve(HttpServletRequest request);

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
}

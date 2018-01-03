package com.gomefinance.hl.security;

import com.gomefinance.hl.security.authentication.filter.MYFilterSecurityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.rememberme.RememberMeAuthenticationFilter;

/**
 * @Author hzj
 * @Date 2017/6/13 19:09
 * @Description :
 */
@Configuration
public class SecurityFilterConfig {


    /**
     *<p> 背景： spring-boot 会自动扫描并配置自定义的Filter ，默认配置为拦截所有的请求（"＼*"）</p>
     *<p>作用：取消securityFilter的自动扫描和配置 </p>
     *
     * @param filter    指定需要被取消的Filter
     * @return
     */
    @Autowired
    @Qualifier(value = "securityFilter")
    @Bean
    public FilterRegistrationBean registration(MYFilterSecurityInterceptor filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }
    /**
     *<p> 背景： spring-boot 会自动扫描并配置自定义的Filter ，默认配置为拦截所有的请求（"＼*"）</p>
     *<p>作用：取消securityFilter的自动扫描和配置 </p>
     *
     * @param filter    指定需要被取消的Filter
     * @return
     */
//    @Autowired
//    @Qualifier(value = "authenticationProcessingFilter")
//    @Bean
//    public FilterRegistrationBean registration4Authentication(AuthenticationProcessingFilter filter) {
//        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
//        registration.setEnabled(false);
//        return registration;
//    }

    /**
     *<p> 背景： spring-boot 会自动扫描并配置自定义的Filter ，默认配置为拦截所有的请求（"＼*"）</p>
     *<p>作用：取消LogoutFilter的自动扫描和配置 </p>
     *
     * @param filter    指定需要被取消的Filter
     * @return
     */
    @Autowired
    @Qualifier(value = "logoutFilter")
    @Bean
    public FilterRegistrationBean registration4LogoutFilter(LogoutFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    /**
     *<p> 背景： spring-boot 会自动扫描并配置自定义的Filter ，默认配置为拦截所有的请求（"＼*"）</p>
     *<p>作用：取消RememberMeAuthenticationFilter的自动扫描和配置 </p>
     *
     * @param filter    指定需要被取消的Filter
     * @return
     */
    @Autowired
    @Bean
    public FilterRegistrationBean registration4RememberMeAuthenticationFilter(RememberMeAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    /**
     *<p> 背景： spring-boot 会自动扫描并配置自定义的Filter ，默认配置为拦截所有的请求（"＼*"）</p>
     *<p>作用：取消LogoutFilter的自动扫描和配置 </p>
     *
     * @param filter    指定需要被取消的Filter
     * @return
     */
    @Autowired
    @Bean
    public FilterRegistrationBean registration4UsernamePasswordAuthenticationFilter(UsernamePasswordAuthenticationFilter filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

    /**
     *<p> 背景： spring-boot 会自动扫描并配置自定义的Filter ，默认配置为拦截所有的请求（"＼*"）</p>
     *<p>作用：取消FilterSecurityInterceptor的自动扫描和配置 </p>
     *
     * @param filter    指定需要被取消的Filter
     * @return
     */
    @Autowired
    @Bean
    public FilterRegistrationBean registration4FilterSecurityInterceptor(FilterSecurityInterceptor filter) {
        FilterRegistrationBean registration = new FilterRegistrationBean(filter);
        registration.setEnabled(false);
        return registration;
    }

}

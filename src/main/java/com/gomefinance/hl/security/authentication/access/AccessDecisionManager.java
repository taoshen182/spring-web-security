package com.gomefinance.hl.security.authentication.access;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * 验证当前用户是否有权限访问请求的资源，决定判决是否通过
 *
 * @Author hzj
 * @Date 2017/6/2 16:48
 * @Description :
 */
public class AccessDecisionManager implements org.springframework.security.access.AccessDecisionManager {
    static final Logger log = LoggerFactory.getLogger(AccessDecisionManager.class);

    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        log.debug("have role:" + authentication.getAuthorities());

        if (configAttributes == null) {
            return;
        }

        // 所请求的资源拥有的权限(一个资源对多个权限)
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        while (iterator.hasNext()) {
            ConfigAttribute configAttribute = iterator.next();
            // 访问所请求资源所需要的权限
            String needPermission = ((SecurityConfig) configAttribute).getAttribute();

            // 用户所拥有的权限authentication
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (needPermission.equalsIgnoreCase(ga.getAuthority())) {
                    log.debug(authentication.getName() + " -> authorization has passed." + authentication.getAuthorities());
                    return;
                }
            }

//			return;
        }


        // 没有权限
        throw new AccessDeniedException(" 没有权限访问！ ");
    }

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

}

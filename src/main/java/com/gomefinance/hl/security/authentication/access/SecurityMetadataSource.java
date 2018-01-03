package com.gomefinance.hl.security.authentication.access;

import com.gomefinance.hl.security.authentication.common.SecurityConstants;
import com.gomefinance.hl.security.mapper.MenuMapper;
import com.gomefinance.hl.security.model.MenuDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * 获取资源和权限的对应关系
 */
public class SecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuMapper menuMapper;

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;
    Logger log = LoggerFactory.getLogger(this.getClass());

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    /**
     * 返回所请求资源所需要的权限<br/>
     *
     * @param object 携带请求资源url信息的 对象
     * @return
     * @throws IllegalArgumentException
     */
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        try {
            Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();

            String requestUrl = ((FilterInvocation) object).getRequestUrl();
            log.debug("requestUrl is " + requestUrl);


//			加载所有资源与权限的关系
//			loadResourceDefine();

            if (requestUrl.indexOf("?") != -1) {
                requestUrl = requestUrl.substring(0, requestUrl.indexOf("?"));
                requestUrl = requestUrl.trim();
            }

            Iterator<String> it = resourceMap.keySet().iterator();
            while (it.hasNext()) {
                String _url = it.next();
                if (_url == null || "".equals(_url)) {
                    continue;
                }
                if (SecurityConstants.matches(_url, requestUrl)) {

                    //保存角色名
                    configAttributes = resourceMap.get(_url);

                    log.debug("need role: {}", configAttributes);
                    break;
                }
            }

            if (configAttributes.isEmpty() && !"/api/applications".equals(requestUrl) && !"/favicon.ico".equals(requestUrl)) {
                log.debug(" 没有权限访问！ ");
                throw new AccessDeniedException(" 没有权限访问！ ");
            }
            if ("/api/applications".equals(requestUrl) || "/monitor".equals(requestUrl)) {
                SecurityConfig api = new SecurityConfig("/api/applications");
                configAttributes.add(api);
                SecurityConfig monitor = new SecurityConfig("/monitor");
                configAttributes.add(monitor);
            }

            return configAttributes;

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }


    /**
     * 加载所有资源与权限的关系<br/>
     * 资源url 与  role 的resourceMap
     */
    @PostConstruct
    private void loadResourceDefine() {

        log.debug("系统资源-权限信息开始加载");

        resourceMap = new HashMap<String, Collection<ConfigAttribute>>();

        List<MenuDO> list = menuMapper.listMenuDO();

        list.stream().forEach(menuDO -> {
            String rescStr = menuDO.getMenuRescStr();
            if (StringUtils.isEmpty(rescStr)) {

            } else if (resourceMap.containsKey(rescStr)) {
                Collection<ConfigAttribute> configAttributes = resourceMap.get(rescStr);
                ConfigAttribute configAttribute = new SecurityConfig(menuDO.getRoleName());
                configAttributes.add(configAttribute);
            } else {
                Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
                // 以权限名封装为Spring的security Object
                ConfigAttribute configAttribute = new SecurityConfig(menuDO.getRoleName());
                configAttributes.add(configAttribute);
                resourceMap.put(rescStr, configAttributes);
            }
        });

//		Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
//		// 以权限名封装为Spring的security Object
//
//		ConfigAttribute configAttributeAdmin = new SecurityConfig(SecurityConstants.ROLE_ANONYMOUS);
//		configAttributes.add(configAttributeAdmin);
//		resourceMap.put("/WEB-INF/jsp/login.jsp",configAttributes);
//
//
//		Collection<ConfigAttribute> configAttributesHomes = new ArrayList<ConfigAttribute>();
//		// 以权限名封装为Spring的security Object
//
//		ConfigAttribute configAttributesHome = new SecurityConfig(SecurityConstants.ROLE_ADMIN);
//		configAttributesHomes.add(configAttributesHome);
//
//		resourceMap.put("/WEB-INF/jsp/index.jsp",configAttributesHomes);
//
//
//		Collection<ConfigAttribute> configAttributesHomes2 = new ArrayList<ConfigAttribute>();
//		// 以权限名封装为Spring的security Object
//
//		ConfigAttribute configAttributesHome2 = new SecurityConfig(SecurityConstants.ROLE_ADMIN);
//		configAttributesHomes2.add(configAttributesHome2);
//		resourceMap.put("/security/home",configAttributesHomes2);
//
//
//		Collection<ConfigAttribute> configAttributesUsers = new ArrayList<ConfigAttribute>();
//		ConfigAttribute configAttributeUser = new SecurityConfig(SecurityConstants.ROLE_ANONYMOUS);
//		configAttributesUsers.add(configAttributeUser);
//		resourceMap.put("/user/login",configAttributesUsers);


        log.debug("系统资源-权限信息加载完毕");

    }


}
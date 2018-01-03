package com.gomefinance.hl.security.authentication.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author hzj
 * @Date 2017/5/9 14:09
 * @Description :
 */
public class MyAuthenticationToken extends UsernamePasswordAuthenticationToken{


    private final static Logger log = LoggerFactory.getLogger(MyAuthenticationToken.class);

    /**
     * 用户储存获取请求自定义的一些属性参数
     */
    private Map<String,String> params = new HashMap<String,String>();

    /**
     * 必须继承此构造方法，并使用super(principal, credentials, authorities)， 次构造方法中会将 authenticated 属性设置为true 表示已认证
     *
     * @param principal     用户名
     * @param credentials   口令
     * @param authorities   用户权限
     * @param params        自定义参数
     */
    public MyAuthenticationToken(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities,Map<String,String> params) {
        super(principal, credentials, authorities);
        this.params = params;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {

        User details = (User) this.getDetails();

        return details.getAuthorities();
    }
}

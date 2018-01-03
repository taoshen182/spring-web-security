package com.gomefinance.hl.security.authentication.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * 安全框架使用的相关常量
 *
 * @Author hzj
 * @Date 2017/5/9 14:50
 * @Description :
 */
public class SecurityConstants {

    /**
     * 用户登录界面input中使用的用于填写用户名的自定义key值，security默认为j_username
     */
    public final static String USERNAME_KEY = "username";
    /**
     * 用户登录界面使用的用户用于填写密码的文本框的自定义可以值，security默认为j_password
     */
    public final static String PASSWORD_KEY = "password";

    /**
     * 认证请求的客户端Ip
     */
    public final static String CLIENT_IP = "client_ip";

    /**
     * 临时是用的ROLE_USER
     */
    public final static String ROLE_USER = "ROLE_USER";

    /**
     * 临时是用的 ROLE_ADMIN
     */
    public final static String ROLE_ADMIN = "ROLE_ADMIN";

    /**
     * 匿名用户角色
     */
    public final static String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

    public static boolean matches(String regex, String path) {
        if (regex == null || "".equals(regex)) {
            return false;
        }
//        if(true){
//            return true;
//        }
        //if(path.startsWith("/admin/menu"))
        //return true;
        regex = Pattern.compile("\\*", Pattern.MULTILINE).matcher(regex).replaceAll("[^/]*");
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(path);
        boolean b = m.matches();
        Pattern p2 = Pattern.compile("/v[^/]*" + regex , Pattern.CASE_INSENSITIVE);
        Matcher m2 = p2.matcher(path);
        boolean b2 = m2.matches();
        return b || b2;
    }


}




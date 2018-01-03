package com.gomefinance.hl.security;

import com.gomefinance.hl.security.authentication.provider.MyAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Author hzj
 * @Date 2017/6/2 17:30
 * @Description :
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Bean
    public MyAuthenticationProvider authenticationProvider(){
        MyAuthenticationProvider authenticationProvider =  new MyAuthenticationProvider();
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);

        web.ignoring().antMatchers("/static/**");

    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);

        auth.authenticationProvider(authenticationProvider());

    }





}

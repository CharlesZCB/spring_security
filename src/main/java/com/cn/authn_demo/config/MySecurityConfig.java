package com.cn.authn_demo.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        //定制请求授权规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/ghost/**").hasRole("Level1")
                .antMatchers("/ghost1/**").hasRole("Level2")
                .antMatchers("/ghost2/**").hasRole("Level3");


        //开启登录功能,没有权限就会来到登陆页面  如果登陆错误会重定向到erro 表示登陆失败
        http.formLogin()
                .loginPage("/userLogin")
                .passwordParameter("pwd")
                .usernameParameter("user");
        //一旦定制页面  loginPost就是登陆逻辑、


        //开启自动配置的注销功能,注销成功来到首页
        http.logout().logoutSuccessUrl("/");

        //记住我的功能
        http.rememberMe().rememberMeParameter("rem");

    }


    //自定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       // super.configure(auth);
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).
                withUser("张三")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("Level1","Level2")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("李四")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("Level2","Level3")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("王五")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("Level3");
    }


}

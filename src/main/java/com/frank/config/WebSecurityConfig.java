package com.frank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.frank.security.CustomUserService;


@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//扩展Spring Security配置需继承WebSecurityConfigurerAdapter 
	
	@Bean
	UserDetailsService customUserService(){ //注册CustomUserService的Bean
		return new CustomUserService(); 
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserService()); //添加我们自定义的user detail service认证
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
						.anyRequest().authenticated() //所有请求需要认证 既登录有才能访问
						.and()
						.formLogin()
							.loginPage("/login")
							.failureUrl("/login?error")
							.permitAll() //定制 登录行为
						.and()
						.logout().permitAll(); //定制注销行为
	}


}

package com.frank.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.frank.dao.SysUserRepository;
import com.frank.domain.SysUser;


public class CustomUserService implements UserDetailsService { //自定义UserDetailsService  
	@Autowired
	SysUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) { //重写loadUserByUsername方法获得用户
		
		SysUser user = userRepository.findByUsername(username); 
		if(user == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		
		return user; //我们当前的 用户实现了UserDetails接口，可直接返回给Spring Security使用
	}
	

}

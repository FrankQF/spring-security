package com.frank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frank.domain.SysUser;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

	SysUser findByUsername(String username);

}

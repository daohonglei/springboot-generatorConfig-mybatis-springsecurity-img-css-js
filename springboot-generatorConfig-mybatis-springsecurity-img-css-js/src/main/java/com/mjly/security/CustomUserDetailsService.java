package com.mjly.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 一个自定义的service用来和数据库进行操作. 即以后我们要通过数据库保存权限.则需要我们继承UserDetailsService
 * 
 */
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserInfoDao userDAO = new UserInfoDao();

	public UserDetails loadUserByUsername(String username)throws UsernameNotFoundException, DataAccessException {
		UserInfo user = null;
		try {
			user = userDAO.getDatabase(username);
			user=new UserInfo(user.getId(),user.getUsername(), user.getPassword().toLowerCase(),user.isEnabled(),getAuthorities(user.getAccess()));
		} catch (Exception e) {
			throw new UsernameNotFoundException("Error in retrieving user");
		}
		return user;
	}

	/**
	 * 获得访问角色权限
	 * @param access
	 * @return
	 */
	public Collection<GrantedAuthority> getAuthorities(Integer access) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		if (access.compareTo(1) == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		return authList;
	}
}

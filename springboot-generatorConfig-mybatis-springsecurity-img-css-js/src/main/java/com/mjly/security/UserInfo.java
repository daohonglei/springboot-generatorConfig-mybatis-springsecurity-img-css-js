package com.mjly.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 实现UserDetails 可以用
 * UserInfo userDetails = (UserInfo) SecurityContextHolder.getContext()
 * 							.getAuthentication().getPrincipal();
 * 获取UserInfo的信息
 *
 */
@SuppressWarnings("serial")
public class UserInfo implements UserDetails{
	private int id;  
    private String username;  
    private String password;  
    private boolean enabled;  
    private int access;
    private Collection<? extends GrantedAuthority> authorities;  
      
    public UserInfo(int id, String username, String password, boolean enabled,int access) {  
        super();  
        this.id = id;  
        this.username = username;  
        this.password = password;  
        this.enabled = enabled;  
        this.access=access;
    }  
      
    public UserInfo(int id, String username, String password, boolean enabled,  
            Collection<? extends GrantedAuthority> authorities) {  
        super();  
        this.id = id;  
        this.username = username;  
        this.password = password;  
        this.enabled = enabled;  
        this.authorities = authorities;  
    }  
    public int getId(){  
        return this.id;  
    }  
  
    @Override  
    public Collection<? extends GrantedAuthority> getAuthorities() {  
        return authorities;  
    }  
    @Override  
    public String getPassword() {  
        return password;  
    }  
    @Override  
    public String getUsername() {  
        return username;  
    }  
    @Override  
    public boolean isAccountNonExpired() {  
        return true;  
    }  
    @Override  
    public boolean isAccountNonLocked() {  
        return true;  
    }  
    @Override  
    public boolean isCredentialsNonExpired() {  
        return true;  
    }  
    @Override  
    public boolean isEnabled() {  
        return enabled;  
    }  
    
    
  
    public int getAccess() {
		return access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	@Override  
    public String toString() {  
        return "MyUserDetails [id=" + id + ", username=" + username  
                + ", password=" + password + ", enabled=" + enabled  
                + ", authorities=" + authorities + "]";  
    }  
	
    
    
}

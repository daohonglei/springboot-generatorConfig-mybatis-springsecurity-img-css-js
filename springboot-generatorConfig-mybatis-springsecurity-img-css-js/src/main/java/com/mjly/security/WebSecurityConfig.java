package com.mjly.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.mjly.security.util.MD5Util;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .authorizeRequests()
         	.antMatchers("/", "/home").permitAll()
            .anyRequest().authenticated()
            //.antMatchers("/admin/").hasRole("ROLE_ADMIN")
           .and()
         .formLogin()
         	.loginPage("/login")
            .defaultSuccessUrl("/hello")
            .failureUrl("/home")
            .permitAll()
            .and()
         .logout()
         	.logoutUrl("logout")
         	.logoutSuccessUrl("/home")
            .permitAll()
            .and()
         .exceptionHandling()
         	.accessDeniedPage("/login?illegal");

    }



    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService()).passwordEncoder(new PasswordEncoder(){
			@Override
			public String encode(CharSequence rawPassword) {
	           return MD5Util.encode((String)rawPassword);
			}
			@Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String)rawPassword));
            }}); 
    }

    /**
     * 自定义UserDetailsService，从数据库中读取用户信息
     * @return
     */
    @Bean
    public UserDetailsService customUserDetailsService(){
        return new CustomUserDetailsService();
    }

}

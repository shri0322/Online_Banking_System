package com.batch8grp1.obs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	    @Override
	    public void configure(HttpSecurity http) throws Exception {
	       http.csrf().disable().authorizeRequests()
	        .antMatchers("/").permitAll()
	        .antMatchers(HttpMethod.POST, "/netbanking/login").permitAll()
	        .antMatchers(HttpMethod.POST, "/netbanking/signup").permitAll()
	        .antMatchers(HttpMethod.POST, "/user/register").permitAll()
	        .antMatchers(HttpMethod.POST, "/user/forgotuserid").permitAll()
	        .anyRequest().authenticated();
	    }
//	@Bean 
//	 public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//	    http.authorizeRequests().antMatchers(
//                "/netbanking/login")
//	      .anyRequest().authenticated()
//	      .and().httpBasic();
//	    return http.build();
//	}
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}

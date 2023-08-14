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
	        .antMatchers(HttpMethod.POST, "/netbanking").permitAll()
	        .antMatchers(HttpMethod.POST, "/user").permitAll()
	        .anyRequest().authenticated();
	    }

	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

}

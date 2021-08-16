package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.security.Filter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private Filter filter;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/articles/**", "/events/**").permitAll()
				.antMatchers(HttpMethod.GET, "/users").hasRole("ADMIN")
				.antMatchers(HttpMethod.GET, "/users/*/**").hasAnyRole("DEFAULT", "ADMIN")
				
				.antMatchers(HttpMethod.POST, "/users/default", "/login").permitAll()
				.antMatchers(HttpMethod.POST, "/articles", "/events", "/users/admin").hasRole("ADMIN")
				.antMatchers(HttpMethod.POST, "/users/*/events/*").hasAnyRole("DEFAULT", "ADMIN")
				
				.antMatchers(HttpMethod.PUT, "/articles/*", "/events/*", "/users/*").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/users/*/events/*").hasAnyRole("DEFAULT", "ADMIN")
				
				.antMatchers(HttpMethod.DELETE, "/articles/*", "/events/*", "/users/*").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/users/*/events/*").hasAnyRole("DEFAULT", "ADMIN")
				
				.anyRequest().denyAll();
	}
	
	@Bean
	public PasswordEncoder encode() {
		return new BCryptPasswordEncoder();
	}
	
}

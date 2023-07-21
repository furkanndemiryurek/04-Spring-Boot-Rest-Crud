package com.staj.restcrud.restcruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

	@Bean
	public InMemoryUserDetailsManager userDetailsManager() {
		UserDetails john = User.builder()
				.username("John")
				.password("{noop}12")
				.roles("EMPLOYEE")
				.build();
		
		UserDetails mary = User.builder()
				.username("Mary")
				.password("{noop}123")
				.roles("EMPLOYEE","MANAGER")
				.build();
		
		UserDetails susan = User.builder()
				.username("Susan")
				.password("{noop}1234")
				.roles("EMPLOYEE","MANAGER","ADMIN")
				.build();
		
		
		return new InMemoryUserDetailsManager(susan, john, mary);
	}
	
	@Bean
	public SecurityFilterChain filterChain (HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests(configurer ->
				configurer
					.requestMatchers(HttpMethod.GET, "/employees").hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.GET, "/students").hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.GET, "/employees/**").hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.GET, "/students/**").hasRole("EMPLOYEE")
					.requestMatchers(HttpMethod.POST, "/employees").hasRole("MANAGER")
					.requestMatchers(HttpMethod.POST, "/students").hasRole("MANAGER")
					.requestMatchers(HttpMethod.PUT, "/employees").hasRole("MANAGER")
					.requestMatchers(HttpMethod.PUT, "/students").hasRole("MANAGER")
					.requestMatchers(HttpMethod.DELETE, "/employees/**").hasRole("ADMIN")
					.requestMatchers(HttpMethod.DELETE, "/students/**").hasRole("ADMIN")
				
				);
		
		http.httpBasic(Customizer.withDefaults());
		http.csrf(csrf -> csrf.disable());
		
		return http.build();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

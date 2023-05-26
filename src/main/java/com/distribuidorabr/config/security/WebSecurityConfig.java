package com.distribuidorabr.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .httpBasic(withDefaults())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/products/**").hasRole("USER")
                .requestMatchers(HttpMethod.PUT, "/products/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/company/**").hasRole("USER")
                .requestMatchers(HttpMethod.POST, "/company/**").hasRole("USER")
                .requestMatchers(HttpMethod.PUT, "/company/**").hasRole("USER")
                .requestMatchers(HttpMethod.GET, "/employee/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.POST, "/employee/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/employee/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/employee/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
		 return http.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
	
}

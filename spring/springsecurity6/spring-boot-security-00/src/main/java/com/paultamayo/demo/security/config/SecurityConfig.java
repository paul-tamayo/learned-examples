package com.paultamayo.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						r -> r.requestMatchers("/my-balance", "/home").authenticated().requestMatchers("/notice").permitAll())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return http.build();
	}
}

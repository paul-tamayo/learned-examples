package com.paultamayo.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(
				r -> r.requestMatchers("/my-balance", "/home").authenticated().requestMatchers("/notice").permitAll())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());

		return http.build();
	}

	// ENFOQUE 1: Con la codificación de la contraseña por defecto
//	@Bean
//	InMemoryUserDetailsManager userDetailsManager() {
//		UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("admin").authorities("admin").build();
//		UserDetails user = User.withDefaultPasswordEncoder().username("user").password("user").authorities("read").build();
//
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	// FIN ENFOQUE 1

	// ENFOQUE 2: 
	@Bean
	PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	InMemoryUserDetailsManager userDetailsManager() {
		UserDetails admin = User.withUsername("admin").password("admin").authorities("admin").build();
		UserDetails user = User.withUsername("user").password("user").authorities("read").build();

		return new InMemoryUserDetailsManager(admin, user);
	}
	// FIN ENFOQUE 2 
}

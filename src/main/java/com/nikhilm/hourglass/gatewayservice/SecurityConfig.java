
package com.nikhilm.hourglass.gatewayservice;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.List;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig {

	@Bean
	SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeExchange()
				.pathMatchers("/health").permitAll()
				.pathMatchers("/swagger/**").permitAll()
				.pathMatchers("/user-service/signup").permitAll()
				.pathMatchers("/user-service/login").permitAll()
				.pathMatchers("/user-service/user/**").permitAll()
				.pathMatchers("/movie-service/**").permitAll()
				.pathMatchers("/tidbits-service/**").permitAll()
				.pathMatchers("/userservice/**").permitAll()
				.pathMatchers(HttpMethod.GET, "/favourites-service/**/user/**").permitAll()
				.anyExchange().authenticated()
				.and()
				.oauth2ResourceServer()
				.jwt();
		return http.build();
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfig = new CorsConfiguration();
		corsConfig.setAllowedOrigins(List.of("*"));
		corsConfig.setMaxAge(3600L);
		corsConfig.addAllowedMethod("*");
		corsConfig.addAllowedHeader("*");

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", corsConfig);
		return source;
	}

}
package com.terzoOne.terzoOneBackend.security;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@SuppressWarnings("removal")
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/auth/**")
                .permitAll()
                .requestMatchers(HttpMethod.GET,"/api/employees").hasAnyAuthority("ADMIN","USER")
                .requestMatchers(HttpMethod.GET,"/api/dashboard/**").hasAnyAuthority("ADMIN","USER")
                .requestMatchers(HttpMethod.GET,"/api/employee/**").hasAnyAuthority("ADMIN","USER")
                .requestMatchers(HttpMethod.PUT,"/api/employee/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.POST,"/api/employee/new").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.DELETE,"/api/employee/**").hasAuthority("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        http.cors();
        return http.build();

    }
}
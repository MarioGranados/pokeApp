package com.poke.pokeApp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;


import com.poke.pokeApp.Service.JwtFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    private final JwtFilter jwtFilter;

    public SecurityConfiguration(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .cors().and()
            .csrf().disable()

            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

            .and()

            .authorizeHttpRequests()
            .requestMatchers("/api/**").permitAll() //permit all requests from here
            .anyRequest().authenticated() //do not allow

            .and()

            .exceptionHandling().accessDeniedPage("/login")

            .and()

            .httpBasic();

            // .addFilterAfter(jwtFilter, UsernamePasswordAuthenticationFilter.class);

            
        return http.build();

    }

}

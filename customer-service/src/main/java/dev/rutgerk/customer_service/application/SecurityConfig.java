package dev.rutgerk.customer_service.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Enable @PreAuthorize and other annotations
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.csrf(csrf -> csrf.disable())

        // Define authorization rules for HTTP requests
        .authorizeHttpRequests(authorizeRequests -> authorizeRequests.requestMatchers("*")
            .permitAll().anyRequest().authenticated() // Secure all other requests
        );

    return http.build();
  }

}

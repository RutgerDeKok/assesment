package dev.rutgerk.customer_service.application;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@Configuration
@EnableMethodSecurity(prePostEnabled = true) // Enable @PreAuthorize and other annotations
public class SecurityConfig {

}

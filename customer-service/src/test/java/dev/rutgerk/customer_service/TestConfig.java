package dev.rutgerk.customer_service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"dev.rutgerk.customer_service", "dev.rutgerk.customer_service.service"})
public class TestConfig {
}

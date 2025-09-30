package com.juliano.desafio_tecnico.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@CrossOrigin
public class WebConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for all endpoints
        registry.addMapping("/**")  // Apply to all endpoints
                .allowedOrigins("http://localhost:8080", "http://localhost:3000", "http://localhost:4200")  // Allow only localhost:3000
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT")
                .allowCredentials(true)
                .allowedHeaders("*") // or specify specific headers, e.g., "Content-Type", "Authorization"
                .exposedHeaders("Content-Type", "Authorization") // or specify specific headers
                .maxAge(3600);
    }
}

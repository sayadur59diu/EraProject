package com.example.SpringProductDesigner.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class ProductDesignerConfig implements WebMvcConfigurer {
    // This class can be used to configure additional settings for the Product Designer module
    // For example, you can add interceptors, view resolvers, etc. if needed in the future.
    @Value("${cors.origin}")
    private String corsOrigin;
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(corsOrigin)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }

}

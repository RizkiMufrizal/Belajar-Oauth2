package com.rizki.mufrizal.belajar.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class WebApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/**").addResourceLocations("/");
        resourceHandlerRegistry.addResourceHandler("/styles/**").addResourceLocations("/app/styles/");
        resourceHandlerRegistry.addResourceHandler("/scripts/**").addResourceLocations("/app/scripts/");
        resourceHandlerRegistry.addResourceHandler("/views/**").addResourceLocations("/app/views/");
        resourceHandlerRegistry.addResourceHandler("/images/**").addResourceLocations("/app/images/");
    }

}

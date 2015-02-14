package com.rizki.mufrizal.belajar.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
@EntityScan(basePackages = {"com.rizki.mufrizal.belajar.oauth2.domain"})
public class WebApplication extends WebMvcConfigurerAdapter{

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry resourceHandlerRegistry) {
        resourceHandlerRegistry.addResourceHandler("/**").addResourceLocations("/");
        //resourceHandlerRegistry.addResourceHandler("/bower_components/**").addResourceLocations("/bower_components/");
        //resourceHandlerRegistry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
    }

}

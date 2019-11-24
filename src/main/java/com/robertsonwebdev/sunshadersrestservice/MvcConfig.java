package com.robertsonwebdev.sunshadersrestservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/admin").setViewName("appointments");
        registry.addViewController("/").setViewName("appointments");
        registry.addViewController("/login").setViewName("login");
    }
}

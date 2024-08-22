package com.coding404.myWeb.config;

import com.coding404.myWeb.interceptor.MenuHandler;
import com.coding404.myWeb.interceptor.UserAuthHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.awt.*;

@Configuration
public class Config implements WebMvcConfigurer {
    @Bean
    public UserAuthHandler userAuthHandler() {
        return new UserAuthHandler();
    }

    @Bean
    public MenuHandler menuHandler() {
        return new MenuHandler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userAuthHandler())
                .addPathPatterns("/product/*")
//                .addPathPatterns("/notice/*")
                .addPathPatterns("/");

        registry.addInterceptor(menuHandler()).addPathPatterns("/**").excludePathPatterns("/user/login");
    }
}

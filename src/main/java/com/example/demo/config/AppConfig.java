package com.example.demo.config;

import com.example.demo.services.CacheService;
import com.example.demo.services.MemcacheService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {


    @Bean
    public CacheService cacheService() {
        CacheService service = new MemcacheService();
        return service;
    }


}

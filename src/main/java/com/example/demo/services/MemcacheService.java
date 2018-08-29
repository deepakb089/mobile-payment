package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class MemcacheService implements CacheService {

    @Override
    public boolean set(String key, String value) {
        return true;
    }

    @Override
    public boolean get(String key) {
        return true;
    }

    @Override
    public String getName() {
        return "memcache";
    }
}

package com.example.demo.services;

public interface CacheService {
    boolean set(String key, String value);
    boolean get(String key);
    String getName();
}

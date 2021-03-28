package com.example.demo.service;

public interface UrlShortenerService {
    String shorten(String url);
    String original(String shortener);
    void remove(String url);
}

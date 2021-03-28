package com.example.demo.service;

public interface ShortenUrlHelperService {

    String getShorterUrl(long index);

    boolean checkUrl(String url);

    String convertToValidUrl(String url);

}

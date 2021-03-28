package com.example.demo.dao;

import com.example.demo.entity.UrlShortener;
import com.example.demo.entity.UrlShortenerKey;

import java.util.List;

public interface UrlShortenerDao {
    void save(List<UrlShortener> urlShortenerList);
    UrlShortener findByKey(UrlShortenerKey urlShortenerKey);
    boolean delete(UrlShortenerKey urlShortenerKey);
    boolean deleteAllRows();
}

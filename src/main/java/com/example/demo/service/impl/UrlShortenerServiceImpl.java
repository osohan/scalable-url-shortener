package com.example.demo.service.impl;

import com.example.demo.dao.UrlShortenerDao;
import com.example.demo.entity.UrlShortener;
import com.example.demo.entity.UrlShortenerKey;
import com.example.demo.service.RangeService;
import com.example.demo.service.ShortenUrlHelperService;
import com.example.demo.service.UrlShortenerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Arrays;

@AllArgsConstructor
@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {

    private UrlShortenerDao urlShortenerDao;
    private RangeService rangeService;
    private ShortenUrlHelperService shortenUrlHelperService;

    @Override
    public String shorten(String url) {
        url = shortenUrlHelperService.convertToValidUrl(url);
        shortenUrlHelperService.checkUrl(url);

        UrlShortener urlShortener = urlShortenerDao.findByKey(
                UrlShortenerKey.builder().key(url).build());
        if (urlShortener != null) {
            return urlShortener.getValue();
        }

        String urlShortForm = shortenUrlHelperService.getShorterUrl(rangeService.getNumber());

        UrlShortener originalUrl = UrlShortener.builder()
                .key(UrlShortenerKey.builder().key(url).build())
                .value(urlShortForm)
                .addedAt(Instant.now())
                .build();

        UrlShortener shortenerUrl = UrlShortener.builder()
                .key(UrlShortenerKey.builder().key(urlShortForm).build())
                .value(url)
                .addedAt(Instant.now())
                .build();

        urlShortenerDao.save(Arrays.asList(originalUrl, shortenerUrl));

        return urlShortForm;
    }

    @Override
    public String original(String shortener) {
        UrlShortener urlShortener = urlShortenerDao.findByKey(UrlShortenerKey.builder().key(shortener).build());
        return urlShortener != null ? urlShortener.getValue() : null;
    }

    @Override
    public void remove(String url) {

    }

}

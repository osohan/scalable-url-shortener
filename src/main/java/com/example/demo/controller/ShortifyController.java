package com.example.demo.controller;

import com.example.demo.dto.GetOriginalRequest;
import com.example.demo.dto.GetOriginalResponse;
import com.example.demo.dto.ShortifyRequest;
import com.example.demo.dto.ShortifyResponse;
import com.example.demo.service.UrlShortenerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ShortifyController {

    private UrlShortenerService urlShortenerService;

    @GetMapping("/v1/shorten")
    public GetOriginalResponse getOriginal(GetOriginalRequest request) {
        return GetOriginalResponse.builder()
                .originalUrl(urlShortenerService.original(request.getId()))
                .build();
    }

    @PostMapping("/v1/shorten")
    public ShortifyResponse shorify(ShortifyRequest shortifyRequest) {
        return ShortifyResponse.builder()
                .shortUrl(urlShortenerService.shorten(shortifyRequest.getLongUrl()))
                .build();
    }

}

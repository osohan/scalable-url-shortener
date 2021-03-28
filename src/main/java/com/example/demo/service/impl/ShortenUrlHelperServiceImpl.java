package com.example.demo.service.impl;

import com.example.demo.service.ShortenUrlHelperService;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShortenUrlHelperServiceImpl implements ShortenUrlHelperService {

    @Override
    public String getShorterUrl(long index) {
        return convertFrom62toDecimal(index, 62);
    }

    @Override
    public boolean checkUrl(String url) {
        try {
            if (!url.contains(".")) {
                return false;
            }
            new URI(url).getHost();
            return true;
        } catch (URISyntaxException ignore) { }
        return false;
    }

    @Override
    public String convertToValidUrl(String url) {
        url = url.trim();
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://" + url;
        }
        return url;
    }

    private String convertFrom62toDecimal(long number, int numberSystem) {
        if (number < numberSystem) {
            return String.valueOf(get62NumberSystemRepresentation(number));
        }

        List<Long> numbersToConvert = new ArrayList<>(10);

        while (true) {
            long a = number / numberSystem;
            long b = number % numberSystem;
            numbersToConvert.add(b);
            number = a;
            if (number < numberSystem) {
                numbersToConvert.add(number);
                break;
            }
        }

        char[] result = new char[numbersToConvert.size()];
        int index = 0;
        for (int i = numbersToConvert.size() - 1; i >= 0; i--) {
            result[index++] = get62NumberSystemRepresentation(numbersToConvert.get(i));
        }

        return String.valueOf(result);
    }

    private char get62NumberSystemRepresentation(long number) {
        String data = "qazxswedcvfrtgbnhyujmkiolpQAZXSWEDCVFRTGBNHYUJMKIOLP1234567890";
        return data.charAt(Math.toIntExact(number));
    }

}

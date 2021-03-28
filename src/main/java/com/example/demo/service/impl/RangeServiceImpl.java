package com.example.demo.service.impl;

import com.example.demo.dao.RangeCounterDao;
import com.example.demo.service.RangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RangeServiceImpl implements RangeService {

    private RangeCounterDao rangeCounterDao;

    @Autowired
    public RangeServiceImpl(RangeCounterDao rangeCounterDao) {
        this.rangeCounterDao = rangeCounterDao;
    }

    private static long rangeCounterValue;
    private static long currentValue;
    private static long maxValue;

    @Value("${rangeSizeForCounter}")
    private int rangeSizeForCounter;

    @Override
    public synchronized long getNumber() {
        if (currentValue >= maxValue) {
            rangeCounterValue = rangeCounterDao.increment();
            currentValue = rangeCounterValue * rangeSizeForCounter;
            maxValue = currentValue + rangeSizeForCounter;
        }
        return currentValue++;
    }

}

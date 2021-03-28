package com.example.demo.dao.impl;

import com.example.demo.dao.RangeCounterDao;
import com.example.demo.entity.RangeCounter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@AllArgsConstructor
@Repository
public class RangeCounterDaoImpl implements RangeCounterDao {

    private EntityManager entityManager;

    @Transactional
    @Override
    public Long increment() {
        RangeCounter rangeCounter = new RangeCounter();
        entityManager.persist(rangeCounter);
        return rangeCounter.getId();
    }

}

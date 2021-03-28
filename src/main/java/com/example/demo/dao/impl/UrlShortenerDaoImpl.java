package com.example.demo.dao.impl;

import com.example.demo.dao.UrlShortenerDao;
import com.example.demo.entity.UrlShortener;
import com.example.demo.entity.UrlShortenerKey;
import lombok.AllArgsConstructor;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@AllArgsConstructor
@Repository
public class UrlShortenerDaoImpl implements UrlShortenerDao {

    private CassandraOperations cassandraTemplate;

    @Override
    public void save(List<UrlShortener> urlShortenerList) {
        cassandraTemplate.batchOps().insert(urlShortenerList).execute();
    }

    @Override
    public UrlShortener findByKey(UrlShortenerKey urlShortenerKey) {
        return cassandraTemplate.selectOneById(urlShortenerKey, UrlShortener.class);
    }

    @Override
    public boolean delete(UrlShortenerKey urlShortenerKey) {
        return cassandraTemplate.deleteById(urlShortenerKey, UrlShortener.class);
    }

    @Override
    public boolean deleteAllRows() {
        return cassandraTemplate.getCqlOperations().execute("TRUNCATE url_shortener");
    }

}

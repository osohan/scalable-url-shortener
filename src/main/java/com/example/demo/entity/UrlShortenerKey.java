package com.example.demo.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyClass;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;

import static org.springframework.data.cassandra.core.cql.PrimaryKeyType.PARTITIONED;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@PrimaryKeyClass
public class UrlShortenerKey {

    @PrimaryKeyColumn(name = "key", type = PARTITIONED)
    private String key;

}

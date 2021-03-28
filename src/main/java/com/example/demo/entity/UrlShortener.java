package com.example.demo.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Table("url_shortener")
public class UrlShortener {

    @PrimaryKey
    private UrlShortenerKey key;

    @Column("value")
    private String value;

    @Column("addedAt")
    private Instant addedAt;

}

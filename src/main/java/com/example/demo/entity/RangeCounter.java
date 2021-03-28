package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Entity
@Table
public class RangeCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

}

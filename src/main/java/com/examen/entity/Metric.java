package com.examen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Metric")
@Data
public class Metric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private float value;
    private String unit;
    private float unitType;
}

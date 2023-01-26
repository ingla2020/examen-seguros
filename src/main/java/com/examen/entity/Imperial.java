package com.examen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Imperial")
@Data
public class Imperial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private float value;
    private String unit;
    private float unitType;
}

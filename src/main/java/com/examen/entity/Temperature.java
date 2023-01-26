package com.examen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "Temperature")
@Data
public class Temperature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "metric_id")
    private Metric metric;
    //@ManyToOne
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "imperial_id")
    private Imperial imperial;
}

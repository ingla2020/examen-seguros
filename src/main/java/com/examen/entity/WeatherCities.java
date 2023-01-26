package com.examen.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "WeatherCities")
@Data
public class WeatherCities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String key;

    @Column(name = "localObservationDateTime")
    private String localObservationDateTime;
    @Column(name = "epochTime")
    private Long epochTime;
    @Column(name = "weatherText")
    private String weatherText;
    @Column(name = "weatherIcon")
    private int weatherIcon;
    @Column(name = "hasPrecipitation")
    private boolean hasPrecipitation;
    @Column(name = "precipitationType")
    private String precipitationType;
    @Column(name = "IsDayTime")
    private boolean isDayTime;
//    @ManyToOne
    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "temperature_object_id")
    private Temperature temperature;
    private String mobileLink;
    private String link;
}

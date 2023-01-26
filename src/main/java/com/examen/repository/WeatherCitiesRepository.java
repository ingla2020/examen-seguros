package com.examen.repository;

import com.examen.entity.WeatherCities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherCitiesRepository extends JpaRepository<WeatherCities, Long> {
}

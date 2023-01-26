package com.examen.services;

import com.examen.dto.CityDto;
import com.examen.dto.WeatherCitiesDto;
import com.examen.exception.WeatherException;

import java.util.List;
import java.util.Map;

public interface AccuWeather {

    List<CityDto> topCities(Integer topCities);
    Map<CityDto, List<WeatherCitiesDto>> weatherFindIdCity(Integer ubicacionClave) throws WeatherException;
    List<Map<CityDto, List<WeatherCitiesDto>>> weatherFindIdCityDb();

}

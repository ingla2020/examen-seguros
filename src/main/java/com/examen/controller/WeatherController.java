package com.examen.controller;

import com.examen.dto.CityDto;
import com.examen.dto.WeatherCitiesDto;
import com.examen.exception.WeatherException;
import com.examen.services.AccuWeather;
import com.examen.validate.EnItemType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class WeatherController {

    @Autowired
    AccuWeather accuWeather;

    @GetMapping("/cities/{top}")
    public ResponseEntity<List<CityDto>> getCities(@PathVariable(name="top") Integer top){
        if (Arrays.stream(EnItemType.values()).filter(eni-> eni.getCode().equals(top)).findFirst().isPresent()
                )
            return ResponseEntity.status(HttpStatus.OK).body(accuWeather.topCities(top));
        else
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/weather/{ubicacionClave}")
    public ResponseEntity<Map<CityDto, List<WeatherCitiesDto>>> getWeather(@PathVariable(name="ubicacionClave") Integer ubicacionClave){

        Map<CityDto, List<WeatherCitiesDto>> mapweather = null;
        try {
            mapweather = accuWeather.weatherFindIdCity(ubicacionClave);
        }catch (WeatherException e){
            if (e.getMessage() == "503")
                return new ResponseEntity(HttpStatus.UNAUTHORIZED);
               else
                return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.OK).body(mapweather);
    }

    @GetMapping("/weather")
    public ResponseEntity<List<Map<CityDto, List<WeatherCitiesDto>>>> getWeather(){
        List<Map<CityDto, List<WeatherCitiesDto>>> list = accuWeather.weatherFindIdCityDb();
        if (list.size() > 0)
            return ResponseEntity.status(HttpStatus.OK).body(list);
         else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}

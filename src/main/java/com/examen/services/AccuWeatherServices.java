package com.examen.services;

import com.examen.dto.CityDto;
import com.examen.dto.WeatherCitiesDto;
import com.examen.entity.WeatherCities;
import com.examen.exception.WeatherException;
import com.examen.repository.WeatherCitiesRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AccuWeatherServices implements AccuWeather {

    @Value(value = "${developer.accuweather.apikey}")
    private String apikey;

    @Value(value = "${developer.accuweather.url}")
    private String topCity;

    @Value(value = "${developer.accuweather.city.url}")
    private String cityUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private WeatherCitiesRepository weatherCities;

    @Override
    public List<CityDto> topCities(Integer topCities) {

        MultiValueMap<String, String> headers = getHeader();

        HttpEntity requestEntity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(topCity);
        builder.queryParam("apikey", apikey);
        String completeUrl = builder.build(topCities).toString();

        ResponseEntity<List<CityDto>> response = restTemplate.exchange(
                completeUrl,
                HttpMethod.GET,
                requestEntity,
                new ParameterizedTypeReference<List<CityDto>>() {
                });

            log.info("fue encontrado :"  + topCity);
            return response.getBody();

    }

    @Override
    public Map<CityDto, List<WeatherCitiesDto>> weatherFindIdCity(Integer ubicacionClave) throws WeatherException{
        MultiValueMap<String, String> headers = getHeader();

        HttpEntity requestEntity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(cityUrl);
        builder.queryParam("apikey", apikey);
        String completeUrl = builder.build(ubicacionClave).toString();
        Map<CityDto, List<WeatherCitiesDto>> joinWeather =null;
        try {

                ResponseEntity<List<WeatherCitiesDto>> response = restTemplate.exchange(
                        completeUrl,
                        HttpMethod.GET,
                        requestEntity,
                        new ParameterizedTypeReference<List<WeatherCitiesDto>>() {
                        });

                List<WeatherCitiesDto> list = response.getBody().stream().map(city ->
                        {
                            city.setKey(ubicacionClave.toString());
                            WeatherCities weather = mapper.map(city, new TypeToken<WeatherCities>() {
                            }.getType());
                            weather.setKey(ubicacionClave.toString());
                            weatherCities.save(weather);
                            return city;
                        }).collect(Collectors.toList());

                joinWeather = joinCityAndWeather(ubicacionClave, list);
            log.info("fue encontrado ubicacionClave :"  + ubicacionClave);

        }catch (HttpStatusCodeException e){
            log.error("no fue encontrado ubicacionClave:"  + ubicacionClave);
                    switch (e.getStatusCode().value()){
                        case 500:
                            throw new WeatherException("500");
                        case 503:
                            throw new WeatherException("503");
                    }
        }catch (Exception ex){
            log.error("Exception ubicacionClave:"  + ubicacionClave);
            throw new WeatherException(ex.getMessage());
        }

        return joinWeather;
    }

    @Override
    public List<Map<CityDto, List<WeatherCitiesDto>>> weatherFindIdCityDb() {
         List<WeatherCities> list = weatherCities.findAll();
        List<WeatherCitiesDto> weather = mapper.map(list, new TypeToken<List<WeatherCitiesDto>>() {
        }.getType());

        return weather
                .stream()
                .map(city-> joinCityAndWeather(Integer.parseInt(city.getKey()), weather))
                .collect(Collectors.toList())
                ;
    }

    private MultiValueMap<String, String> getHeader(){
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.add("Content-Type", "application/json");
        return headers;
    }

    private Map<CityDto, List<WeatherCitiesDto>> joinCityAndWeather(Integer ubicacionClave, List<WeatherCitiesDto> list){
        CityDto cities = topCities(150)
                .stream()
                .filter(filter-> filter.getKey().equals(ubicacionClave.toString()))
                .collect(Collectors.toList()).get(0);
        Map<CityDto, List<WeatherCitiesDto>> listcity = new HashMap<>();
        listcity.put(cities, list);
        return listcity;
    }
}

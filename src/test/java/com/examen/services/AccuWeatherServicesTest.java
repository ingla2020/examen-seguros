package com.examen.services;

import com.examen.dto.CityDto;
import com.examen.dto.WeatherCitiesDto;
import com.examen.entity.WeatherCities;
import com.examen.repository.WeatherCitiesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource("/application-test.properties")
@RunWith(SpringRunner.class)
public class AccuWeatherServicesTest {

    @Autowired
    AccuWeather accuWeather;

    @MockBean
    public RestTemplate restTemplate;

    @Mock
    private WeatherCitiesRepository weatherCities;

    @Value(value = "${developer.accuweather.apikey}")
    private String apikey;

    @Value(value = "${developer.accuweather.url}")
    private String topCity;

    @Value(value = "${developer.accuweather.city.url}")
    private String cityUrl;

    @Test
    public void topCitiesTest(){
        CityDto city = new CityDto();
        city.setKey(apikey);
        List<CityDto> list = new ArrayList<>();
        list.add(city);

        ResponseEntity<List<CityDto>> agendaResponse = new ResponseEntity<List<CityDto>>(list,
                HttpStatus.OK);

        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(agendaResponse);

        List<CityDto> result = accuWeather.topCities(50);
        assertThat(apikey).isEqualTo(result.get(0).getKey());
    }


    @Test(expected = Exception.class)
    public void weatherFindIdCityTest(){

        WeatherCitiesDto weather = new WeatherCitiesDto();
        weather.setKey(apikey);
        List<WeatherCitiesDto> list = new ArrayList<>();
        list.add(weather);

        ResponseEntity<List<WeatherCitiesDto>> agendaResponse = new ResponseEntity<List<WeatherCitiesDto>>(list,
                HttpStatus.OK);

        when(restTemplate.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class),
                any(ParameterizedTypeReference.class))).thenReturn(agendaResponse);

        when(weatherCities.save(Mockito.any(WeatherCities.class)))
                .thenAnswer(i -> i.getArguments()[0]);

        Map<CityDto, List<WeatherCitiesDto>> result = accuWeather.weatherFindIdCity(50);
        assertThat(apikey).isEqualTo(result.entrySet().stream().map(Map.Entry::getValue).map(x->x.get(0).getKey()).findFirst().get());
    }

}

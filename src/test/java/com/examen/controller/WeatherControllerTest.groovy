package com.examen.controller

import com.examen.dto.CityDto
import com.examen.dto.WeatherCitiesDto
import com.examen.services.AccuWeather
import spock.lang.Specification

class WeatherControllerTest extends Specification{
    def controller = new WeatherController()
    def accuWeather = Mock(AccuWeather);

    def setup(){
        controller.accuWeather = accuWeather
    }

    def "Consulta de Top Ciudades"(){
        def top = 50
        def listcityDto = [new CityDto(
                                                        key : 7894 ,
                                                        localizedName : "Buenos Aires",
                                                        englishName : "Buenos Aires"
                                            )]

        when: "Inicia Servicio"
        def responseEntity = controller.getCities(top)
        then: "Carga top 50"
        1 * accuWeather.topCities(top) >> listcityDto
        notThrown()
        and: "retorna la respuesta esperada"
        responseEntity.statusCodeValue == 200
        responseEntity.body == listcityDto

    }

    def "Consulta del clima por ubicacion"(){
        def top = 50
        def key =  7894
        def cityDto = new CityDto(
                key : key ,
                localizedName : "Buenos Aires",
                englishName : "Buenos Aires"
        )
        def listWeather = new WeatherCitiesDto(
                key : key ,
                localObservationDateTime : "2023-01-25T17:55:00-03:00",
                epochTime : 1.67468006E9
        )
        def listcityDto = [cityDto]
        Map map = [cityDto: [listWeather]]

        when: "Inicia Servicio"
        def responseEntity = controller.getWeather(key)
        then: "Servicio Consulta el clima por ubicacion"
        1 * accuWeather.weatherFindIdCity(key) >> map
        notThrown()
        and: "retorna la respuesta esperada"
        responseEntity.statusCodeValue == 200
        responseEntity.body == map

    }


    def "Consulta de las anterires consulta almacenada en la base"(){
        def top = 50
        def key =  7894
        def cityDto = new CityDto(
                key : key ,
                localizedName : "Buenos Aires",
                englishName : "Buenos Aires"
        )
        def listWeather = new WeatherCitiesDto(
                key : key ,
                localObservationDateTime : "2023-01-25T17:55:00-03:00",
                epochTime : 1.67468006E9
        )
        def listcityDto = [cityDto]
        Map map = [cityDto: [listWeather]]
        def listmap = [map]
        when: "Inicia Controlador"
        def responseEntity = controller.getWeather()
        then: "Servicio Consulta en la base"
        1 * accuWeather.weatherFindIdCityDb() >> listmap
        and: "retorna la respuesta esperada"
        responseEntity.statusCodeValue == 200
        responseEntity.body == listmap

    }
}

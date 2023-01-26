package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WeatherCitiesDto {

    private String key;
    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;
    @JsonProperty("EpochTime")
    private Long epochTime;
    @JsonProperty("WeatherText")
    private String weatherText;
    @JsonProperty("WeatherIcon")
    private int weatherIcon;
    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private String precipitationType;
    @JsonProperty("IsDayTime")
    private boolean isDayTime;
    @JsonProperty("Temperature")
    private TempeElevationDto temperature;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
}

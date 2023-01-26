package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CityDto implements Serializable {
    @JsonProperty("Key")
    private String key;
    @JsonProperty("LocalizedName")
    private String localizedName;
    @JsonProperty("EnglishName")
    private String englishName;
    @JsonProperty("Country")
    CountryDto country;
    @JsonProperty("TimeZone")
    TimeZoneDto timeZone;
    @JsonProperty("GeoPositionObject")
    GeoPositionDto geoPositionObject;
    @JsonProperty("LocalObservationDateTime")
    private String localObservationDateTime;
    @JsonProperty("EpochTime")
    private float epochTime;
    @JsonProperty("WeatherText")
    private String weatherText;
    @JsonProperty("WeatherIcon")
    private float weatherIcon;
    @JsonProperty("HasPrecipitation")
    private boolean hasPrecipitation;
    @JsonProperty("PrecipitationType")
    private String precipitationType = null;
    @JsonProperty("IsDayTime")
    private boolean isDayTime;
    @JsonProperty("TemperatureObject")
    TempeElevationDto temperatureObject;
    @JsonProperty("MobileLink")
    private String mobileLink;
    @JsonProperty("Link")
    private String link;
}

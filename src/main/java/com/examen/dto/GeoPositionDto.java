package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GeoPositionDto {
    @JsonProperty("Latitude")
    private float latitude;
    @JsonProperty("Longitude")
    private float longitude;
    @JsonProperty("ElevationObject")
    TempeElevationDto elevationObject;
}

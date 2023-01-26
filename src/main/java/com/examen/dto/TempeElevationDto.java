package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TempeElevationDto {
    @JsonProperty("Metric")
    MetricImpeDto metric;
    @JsonProperty("Imperial")
    MetricImpeDto imperial;
}

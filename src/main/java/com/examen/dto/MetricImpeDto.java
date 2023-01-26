package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MetricImpeDto {
    @JsonProperty("Value")
    private float value;
    @JsonProperty("Unit")
    private String unit;
    @JsonProperty("UnitType")
    private float unitType;
}

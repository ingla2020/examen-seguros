package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TimeZoneDto {
    @JsonProperty("Code")
    private String code;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("GmtOffset")
    private float gmtOffset;
    @JsonProperty("IsDaylightSaving")
    private boolean isDaylightSaving;
    @JsonProperty("NextOffsetChange")
    private String nextOffsetChange = null;
}

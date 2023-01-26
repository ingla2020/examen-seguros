package com.examen.validate;


import lombok.Getter;
import org.springframework.web.client.HttpClientErrorException;

import java.util.stream.Stream;

@Getter
public enum EnItemType {
    TYPE1(50),
    TYPE2(100),
    TYPE3(150);

    private Integer code;

    EnItemType(Integer code) {
        this.code=code;
    }

    public static EnItemType decode(final int code) {
        return Stream.of(EnItemType.values())
                .filter(targetEnum -> targetEnum.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Failed to find FormHttpMessageConverter"))
                //.orElseThrow(() -> new HttpClientErrorException.BadRequest())
                ;
    }

}

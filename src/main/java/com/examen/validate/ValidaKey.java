package com.examen.validate;

import lombok.Data;

@Data
public class ValidaKey {

    private Integer ubicacionClave;

    public ValidaKey(Integer ubicacionClave) {
        this.ubicacionClave = ubicacionClave;
    }
}

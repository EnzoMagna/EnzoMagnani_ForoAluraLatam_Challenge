package com.foroAluraLatam.demo.domain.usuarios;

public class ValidacionException extends RuntimeException {

    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}

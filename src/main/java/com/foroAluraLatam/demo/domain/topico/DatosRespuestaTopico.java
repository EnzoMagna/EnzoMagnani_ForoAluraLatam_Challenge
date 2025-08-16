package com.foroAluraLatam.demo.domain.topico;

import com.foroAluraLatam.demo.domain.Curso;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        boolean status,
        String autor,
        Curso curso
) {
}

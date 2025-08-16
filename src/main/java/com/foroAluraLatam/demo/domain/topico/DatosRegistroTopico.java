package com.foroAluraLatam.demo.domain.topico;

import com.foroAluraLatam.demo.domain.Curso;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(

        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotBlank String autor,
        @NotNull Curso curso

) {
}

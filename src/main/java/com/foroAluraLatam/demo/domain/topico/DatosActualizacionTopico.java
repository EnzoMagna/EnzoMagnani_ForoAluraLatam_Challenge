package com.foroAluraLatam.demo.domain.topico;

import com.foroAluraLatam.demo.domain.Curso;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(@NotNull Long id, String titulo, String mensaje, String autor, Curso curso) {
}

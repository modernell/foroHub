package com.alura.foroHub.domain.topico;

import com.alura.foroHub.domain.curso.Curso;
import com.alura.foroHub.domain.respuesta.Respuesta;
import com.alura.foroHub.domain.usuario.Usuario;
import com.alura.foroHub.domain.usuario.UsuarioRegistroDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TopicoRegistroDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        LocalDate fechaCreacion,
        @NotBlank
        String status,
        @NotBlank
        @NotNull
        Long autor_id,
        @NotBlank
        Long curso_id
) {
}

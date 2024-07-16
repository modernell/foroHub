package com.alura.foroHub.domain.usuario;

import com.alura.foroHub.domain.curso.Curso;
import com.alura.foroHub.domain.perfil.Perfil;
import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record UsuarioRegistroDTO(
        @NotBlank  String nombre, String correoElectronico, @NotBlank String contrasenha, Long perfil_id
) {
}

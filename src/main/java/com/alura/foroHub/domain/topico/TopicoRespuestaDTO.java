package com.alura.foroHub.domain.topico;

import com.alura.foroHub.domain.curso.Curso;
import com.alura.foroHub.domain.respuesta.Respuesta;
import com.alura.foroHub.domain.usuario.Usuario;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record TopicoRespuestaDTO(
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        String status,
        Usuario autor,
        Curso curso
) {
    public TopicoRespuestaDTO(Topico topico, Curso curso, Usuario usuario){
        this(topico.getTitulo(),topico.getMensaje(),topico.getFechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso());
    }

}

package com.alura.foroHub.domain.topico;

import com.alura.foroHub.domain.curso.Curso;
import com.alura.foroHub.domain.respuesta.Respuesta;
import com.alura.foroHub.domain.usuario.Usuario;

import java.time.LocalDate;
import java.util.List;

public record TopicoListadoDTO(
        String titulo,
        String mensaje,
        LocalDate fechaCreacion,
        String status,
        Usuario autor,
        Curso curso,
        List<Respuesta> respuestas
) {
    public  TopicoListadoDTO(Topico topico){
        this(topico.getTitulo(), topico.getMensaje(),topico.getFechaCreacion(),topico.getStatus(),topico.getAutor(),topico.getCurso(),
                topico.getRespuestas());
    }
}

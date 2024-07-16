package com.alura.foroHub.domain.respuesta;

import com.alura.foroHub.domain.usuario.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RespuestaRespository extends JpaRepository<Respuesta,Long> {
}

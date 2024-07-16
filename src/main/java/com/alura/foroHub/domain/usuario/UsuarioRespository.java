package com.alura.foroHub.domain.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRespository extends JpaRepository<Usuario,Long> {
    UserDetails findByNombre(String subject);
}

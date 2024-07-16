package com.alura.foroHub.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.alura.foroHub.domain.usuario.UsuarioRespository;

@Service
public class AuthenticacionService implements UserDetailsService {
    @Autowired
    UsuarioRespository usuarioRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return  usuarioRepository.findByNombre(username);
    }
}

package com.alura.foroHub.controller;

import com.alura.foroHub.domain.perfil.Perfil;
import com.alura.foroHub.domain.perfil.PerfilRegistroDTO;
import com.alura.foroHub.domain.perfil.PerfilRepository;
import com.alura.foroHub.domain.usuario.Usuario;
import com.alura.foroHub.domain.usuario.UsuarioRegistroDTO;
import com.alura.foroHub.domain.usuario.UsuarioRespository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    PerfilRepository perfilRepository;
    @Autowired
    UsuarioRespository usuarioRespository;
    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody @Valid UsuarioRegistroDTO usuarioRegistroDTO){
        Usuario usuario = new Usuario(usuarioRegistroDTO);
        String encodedPasword =passwordEncoder.encode(usuarioRegistroDTO.contrasenha());
        Optional<Perfil> perfil = perfilRepository.findById(usuarioRegistroDTO.perfil_id());
        usuario.setPerfil(perfil.get());
        usuario.setContrasenha(encodedPasword);
        usuarioRespository.save(usuario);
        return  new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getAllCursos(){
        return  new ResponseEntity<>(usuarioRespository.findAll(),HttpStatus.OK);
    }
}

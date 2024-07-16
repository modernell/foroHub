package com.alura.foroHub.controller;

import com.alura.foroHub.domain.perfil.Perfil;
import com.alura.foroHub.domain.usuario.DatosAutenticacionUsuario;
import com.alura.foroHub.domain.usuario.Usuario;
import com.alura.foroHub.domain.usuario.UsuarioRegistroDTO;
import com.alura.foroHub.infra.security.DTOJWTtoken;
import com.alura.foroHub.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;
    @PostMapping
    public ResponseEntity<?> authentication(@RequestBody @Valid DatosAutenticacionUsuario datosAutenticacionUsuario){
        System.out.println("endpoints ok");

        Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticacionUsuario.login(),datosAutenticacionUsuario.clave());

        var userAuthenticated = authenticationManager.authenticate(authToken);
        System.out.println("Has sido authenticado");

        var JWTtoken = tokenService.generarToken((Usuario) userAuthenticated.getPrincipal());
        System.out.println("se genero tu token: "+JWTtoken);
        return  ResponseEntity.ok(new DTOJWTtoken(JWTtoken));
    }

}

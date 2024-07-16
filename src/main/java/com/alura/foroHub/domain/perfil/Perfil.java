package com.alura.foroHub.domain.perfil;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.alura.foroHub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "perfiles")
@Entity(name = "Perfil")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre_perfil",unique = true)
    private String nombrePerfil;
    @JsonIgnore
    @OneToMany(mappedBy = "perfil")
    List<Usuario> usuarioList;

    public Perfil(PerfilRegistroDTO perfilRegistroDTO) {
        this.nombrePerfil=perfilRegistroDTO.nombrePerfil();
    }
}

package com.alura.foroHub.domain.curso;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.alura.foroHub.domain.perfil.PerfilRepository;
import com.alura.foroHub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "curso")
@Entity(name = "Curso")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String nombreCurso;
    private String categoria;
    @JsonIgnore
    @OneToMany(mappedBy = "curso")
    List<Topico> topicoList;
    public Curso() {
    }
   public Curso(CursoRegistroDTO cursoRegistroDTO) {
        this.nombreCurso=cursoRegistroDTO.nombreCurso();
        this.categoria=cursoRegistroDTO.categoria();
   }

}

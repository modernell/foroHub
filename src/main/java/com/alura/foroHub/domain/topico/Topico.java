package com.alura.foroHub.domain.topico;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.alura.foroHub.domain.curso.Curso;
import com.alura.foroHub.domain.curso.CursoRegistroDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.alura.foroHub.domain.usuario.Usuario;
import com.alura.foroHub.domain.respuesta.Respuesta;

import java.time.LocalDate;
import java.util.List;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotBlank
    private String mensaje;

    @NotNull
    private LocalDate fechaCreacion;

    @NotBlank
    private String status;

    @ManyToOne
    @NotNull
    private Usuario autor;

    @ManyToOne
    @NotNull
    private Curso curso;

    @JsonIgnore
    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Respuesta> respuestas;

    public Topico(TopicoRegistroDTO topicoRegistroDTO) {
        this.titulo = topicoRegistroDTO.titulo();
        this.mensaje=topicoRegistroDTO.mensaje();
        this.fechaCreacion=topicoRegistroDTO.fechaCreacion();
        this.status=topicoRegistroDTO.status();
    }
}

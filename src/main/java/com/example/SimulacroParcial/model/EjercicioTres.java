package com.example.SimulacroParcial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
@Builder
@Table(name = "ejercicio_tres")
public class EjercicioTres {

    @Id
    private Integer id;

    private List<Usuario> usuarios;

    private List<Publicacion> publicaciones;

    private List<Comentario> comentarios;


}

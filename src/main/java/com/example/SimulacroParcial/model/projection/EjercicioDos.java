package com.example.SimulacroParcial.model.projection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class EjercicioDos {

    @Id
    private String publicacion;
    private String nombre;
    private Integer cantidad;


}

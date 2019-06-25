package com.example.SimulacroParcial.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

import static java.util.Objects.isNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comentario_id")
    private Integer id;

    private String descripcion;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;


    //@JoinColumn(name = "usuario_id", referencedColumnName = "id")
    //private Usuario owner;
    private String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacion_id", referencedColumnName = "publicacion_id")
    @JsonIgnore
    private Publicacion publicacion;

    @PrePersist
    public void setFecha(){
        if(isNull(this.fecha))
            this.fecha = LocalDate.now();
    }
}

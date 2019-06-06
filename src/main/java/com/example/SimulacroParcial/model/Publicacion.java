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
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    private String descripcion;

    private String foto;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MMM/yyyy")
    private LocalDate fechaPublicacion;

    private Integer liked;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    @JsonIgnore
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL, mappedBy = "publicacion")
    private List<Comentario> comentarios;



    @PrePersist
    public void setFechaPublicacion(){
        if(isNull(this.fechaPublicacion))
            this.fechaPublicacion = LocalDate.now();
    }
}

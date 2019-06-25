package com.example.SimulacroParcial.model.projection;


import org.springframework.beans.factory.annotation.Value;

public interface EjercicioUno {

    String getPublicacion();
    String getNombre();

    //@Value("#{target.cantidad}")
    String getCantidad();
}

package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService publicacionService;

    @PostMapping("/usuario/{id}")
    public void add(@RequestBody final Publicacion publicacion, @PathVariable("id") final Integer idUsuario){
        publicacionService.add(publicacion,idUsuario);
    }

    @GetMapping("")
    public List<Publicacion> getAll(){
        return publicacionService.getAll();
    }
}

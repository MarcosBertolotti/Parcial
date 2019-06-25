package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.model.projection.EjercicioDos;
import com.example.SimulacroParcial.model.projection.EjercicioUno;
import com.example.SimulacroParcial.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("ejercicioUno/{nombre]")
    public ResponseEntity<List<EjercicioUno>> getEjercicioUno(@PathVariable("nombre") final String nombre){
        try{

            List<EjercicioUno> list = publicacionService.getEjercicioUno(nombre);

            if(list.size() > 0)
                return ResponseEntity.ok(list);
            else
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("ejercicioDos/{nombre]")
    public ResponseEntity<List<EjercicioDos>> getEjercicioDos(@PathVariable("nombre") final String nombre){
        try{

            List<EjercicioDos> list = publicacionService.getEjercicioDos(nombre);

            if(list.size() > 0)
                return ResponseEntity.ok(list);
            else
                return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Comentario;
import com.example.SimulacroParcial.model.EjercicioTres;
import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.model.Usuario;
import com.example.SimulacroParcial.service.EjercicioTresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/allContent")
public class EjercicioTresController {

    @Autowired
    private EjercicioTresService ejercicioTresService;

    @Autowired
    private EjercicioTres ejercicioTres;

    @GetMapping("")
    public ResponseEntity<?> getAllContentAsync(){

        try {
            CompletableFuture<List<Usuario>> usuarios = ejercicioTresService.getAllUsuarioAsync();
            CompletableFuture<List<Publicacion>> publicaciones = ejercicioTresService.getAllPublicacionAsync();
            CompletableFuture<List<Comentario>> comentarios = ejercicioTresService.getAllComentarioAsync();

            ejercicioTres.builder()
                    .usuarios(usuarios.join())
                    .publicaciones(publicaciones.join())
                    .comentarios(comentarios.join())
                    .build();

            return ResponseEntity.ok(ejercicioTres);

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Comentario;
import com.example.SimulacroParcial.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @PostMapping("publicacion/{id}")
    public void add(@RequestBody final Comentario comentario, @PathVariable("id") final Integer idPublicacion){
        comentarioService.add(comentario,idPublicacion);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") final Integer id){
        comentarioService.deleteById(id);
    }

    @Scheduled(fixedRate = 120000) // 120000 milisegundos = 2 minutos  (creo xD) (>o.o)> (^.^) <(o.o<)
    public void deleteEveryXTime(Integer time){
        comentarioService.deleteEveryXtime(time);
    }
}

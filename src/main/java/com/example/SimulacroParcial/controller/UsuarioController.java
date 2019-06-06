package com.example.SimulacroParcial.controller;

import com.example.SimulacroParcial.model.Usuario;
import com.example.SimulacroParcial.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("")
    public void add(@RequestBody final Usuario usuario, @RequestHeader HttpHeaders header){

        String userAgent = String.valueOf(header.get("user-agent"));
        usuario.setBrowser(userAgent);

        usuarioService.add(usuario);
    }

    @PutMapping("")
    public void update(@RequestBody final Usuario usuario){
        usuarioService.update(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") final Integer id){
        usuarioService.deleteById(id);
    }

    @GetMapping("")
    public List<Usuario> getAll(){
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public Usuario getById(@PathVariable("id") final Integer id){
        return usuarioService.getById(id);
    }
}

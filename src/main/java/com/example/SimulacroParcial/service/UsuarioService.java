package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.model.Usuario;
import com.example.SimulacroParcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class UsuarioService {

    private final static String USUARIO_NOT_FOUND = "No existe usuario con id: %s";

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public void add(final Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void update(final Usuario usuario){
        Integer id = usuario.getId();

        Usuario oldUsuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(USUARIO_NOT_FOUND,id)));

        if(usuario.equals(oldUsuario))
            usuarioRepository.save(usuario);
    }

    public void deleteById(final Integer id){

        usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(USUARIO_NOT_FOUND,id)));

        usuarioRepository.deleteById(id);
    }

    public List<Usuario> getAll(){
        return usuarioRepository.findAll();
    }

    public Usuario getById(final Integer id){

        return usuarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(USUARIO_NOT_FOUND,id)));
    }

}

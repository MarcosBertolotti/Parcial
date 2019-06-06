package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.model.Usuario;
import com.example.SimulacroParcial.repository.IPublicacionRepository;
import com.example.SimulacroParcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

@Service
public class PublicacionService {

    private final static String USUARIO_NOT_FOUND = "No existe usuario con id: %s";

    @Autowired
    private IPublicacionRepository publicacionRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    public void add(final Publicacion publicacion, final Integer idUsuario){

        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(USUARIO_NOT_FOUND,idUsuario)));

        usuario.getPublicaciones().add(publicacion);
        publicacion.setUsuario(usuario);

        publicacionRepository.save(publicacion);
        // si no hacer save de usuario
    }

    public List<Publicacion> getAll(){
        return publicacionRepository.findAll();
    }


}

package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.model.Comentario;
import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.repository.IComentarioRepository;
import com.example.SimulacroParcial.repository.IPublicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class ComentarioService {

    private final static String PUBLICACION_NOT_FOUND = "No existe publicacion con id: %s";
    private final static String COMENTARIO_NOT_FOUND = "No existe comentario con id: %s";

    @Autowired
    private IComentarioRepository comentarioRepository;

    private IPublicacionRepository publicacionRepository;

    public void add(final Comentario comentario, final Integer idPublicacion){

        Publicacion publicacion =publicacionRepository.findById(idPublicacion)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(PUBLICACION_NOT_FOUND,idPublicacion)));

        publicacion.getComentarios().add(comentario);
        //comentario.setOwner(publicacion.getUsuario());
        comentario.setOwner(publicacion.getUsuario().getNombre());

        comentarioRepository.save(comentario);
    }

    public void deleteById(final Integer id){

        comentarioRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.BAD_REQUEST,String.format(COMENTARIO_NOT_FOUND,id)));

        comentarioRepository.deleteById(id);
    }

    public void deleteEveryXtime(Integer time){

        comentarioRepository.deleteEveryXtime(time);
    }
}

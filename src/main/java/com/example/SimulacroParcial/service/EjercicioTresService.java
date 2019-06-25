package com.example.SimulacroParcial.service;

import com.example.SimulacroParcial.model.Comentario;
import com.example.SimulacroParcial.model.EjercicioTres;
import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.model.Usuario;
import com.example.SimulacroParcial.repository.IComentarioRepository;
import com.example.SimulacroParcial.repository.IEjercicioTresRepository;
import com.example.SimulacroParcial.repository.IPublicacionRepository;
import com.example.SimulacroParcial.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class EjercicioTresService {

    @Autowired
    private IEjercicioTresRepository ejercicioTresRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IPublicacionRepository publicacionRepository;

    @Autowired
    private IComentarioRepository comentarioRepository;

    @Async("ThreadPoolTaskExecutor")
    public CompletableFuture<List<Usuario>> getAllUsuarioAsync(){

        List<Usuario> list = new ArrayList<>();

        try {
            list = usuarioRepository.findAll();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(list);
    }

    @Async("ThreadPoolTaskExecutor")
    public CompletableFuture<List<Publicacion>> getAllPublicacionAsync(){

        List<Publicacion> list = new ArrayList<>();

        try {
            list = publicacionRepository.findAll();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(list);
    }

    @Async("ThreadPoolTaskExecutor")
    public CompletableFuture<List<Comentario>> getAllComentarioAsync(){

        List<Comentario> list = new ArrayList<>();

        try {
            list = comentarioRepository.findAll();
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(list);
    }
}

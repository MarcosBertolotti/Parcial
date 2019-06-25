package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.model.Publicacion;
import com.example.SimulacroParcial.model.projection.EjercicioUno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPublicacionRepository extends JpaRepository<Publicacion,Integer> {

    @Query(value = "select p.titulo as publicacion, u.nombre, count(c.id) as cantidad " +
            "from usuarios u " +
            "inner join publicaciones p on p.usuario_id = u.usuario_id " +
            "inner join comentarios c on c.publicacion_id = p.publicacion_id " +
            "where u.nombre = ?1 " +
            "group by p.publicacion_id", nativeQuery = true)
    List<EjercicioUno> getEjercicioUno(String nombre);
}



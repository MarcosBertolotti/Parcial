package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.model.projection.EjercicioDos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEjercicioDosRepository extends JpaRepository<EjercicioDos,String> {

    @Query(value = "select p.titulo as publicacion, u.nombre, count(c.id) as cantidad " +
            "from usuarios u " +
            "inner join publicaciones p on p.usuario_id = u.usuario_id " +
            "inner join comentarios c on c.publicacion_id = p.publicacion_id " +
            "where u.nombre = ?1 " +
            "group by p.publicacion_id", nativeQuery = true)
    List<EjercicioDos> getEjercicioDos(String nombre);

}

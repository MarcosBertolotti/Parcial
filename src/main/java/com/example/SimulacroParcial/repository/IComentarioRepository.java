package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IComentarioRepository extends JpaRepository<Comentario,Integer> {

    @Query(value = "delete from comentarios where fecha < now() - ?1;",nativeQuery = true )
    void deleteEveryXtime(Integer time);
}

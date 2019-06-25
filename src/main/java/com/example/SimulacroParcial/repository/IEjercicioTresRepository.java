package com.example.SimulacroParcial.repository;

import com.example.SimulacroParcial.model.EjercicioTres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEjercicioTresRepository extends JpaRepository<EjercicioTres,Integer> {


}

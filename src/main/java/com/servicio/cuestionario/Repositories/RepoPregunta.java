package com.servicio.cuestionario.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.cuestionario.entities.Pregunta;

@Repository
public interface RepoPregunta extends JpaRepository<Pregunta, Long> {


    
}

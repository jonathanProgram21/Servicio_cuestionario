package com.servicio.cuestionario.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.cuestionario.entities.Evento;

@Repository
public interface RepoEvento extends JpaRepository<Evento, Long> {


    List<Evento> findAll();

    
}

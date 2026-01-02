package com.servicio.cuestionario.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicio.cuestionario.entities.Cuestionario;

@Repository
public interface RepoCuestionario extends JpaRepository< Cuestionario, Long>{
}

package com.servicio.cuestionario.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.servicio.cuestionario.entities.Estatus;
import com.servicio.cuestionario.entities.Respuestas;

@Repository
public interface RepoRespuestas extends JpaRepository<Respuestas, Long> {

    long findByFkEventoId(Long eventoId);

    Optional<Respuestas> findByFkEvento_IdAndFkPregunta_Id(Long eventoId, Long preguntaId);

    @Modifying
    @Query("UPDATE Respuestas r SET r.estatus = :estatus WHERE r.fkEvento.id = :eventoId")
    void updateEstatusByEventoId(Long eventoId, Estatus estatus);

    @Query("SELECT r FROM Respuestas r WHERE r.fkEvento.id = :fkEvento")
    List<Respuestas> findByFkEvento(Long fkEvento);

}

package com.servicio.cuestionario.Services;

import org.springframework.stereotype.Service;

import com.servicio.cuestionario.DTOs.EventoRequestDTO;
import com.servicio.cuestionario.Repositories.RepoCuestionario;
import com.servicio.cuestionario.Repositories.RepoEvento;

import com.servicio.cuestionario.entities.Cuestionario;
import com.servicio.cuestionario.entities.Evento;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EventoServiceImpl implements IEventoService {

    private final RepoCuestionario repoCuestionario;
    private final RepoEvento repoEvento;

    public EventoServiceImpl(RepoCuestionario cuestionario, RepoEvento evento) {
        this.repoCuestionario = cuestionario;
        this.repoEvento = evento;
    }


    @Override
    public Long registrarEvento(
        Long cuestionarioId,
        String nombreEvento,
        String descripcion,
        String entradaStaff,
        String salidaStaff,
        String entradaPublico,
        String salidaPublico,
        String fechaEvento
    ) {
        Cuestionario c = repoCuestionario.findById(cuestionarioId).orElseThrow(() -> new IllegalArgumentException("Cuestionario no encontrado"));
        
        Evento evento = new Evento();
        evento.setNombreEvento(nombreEvento);
        evento.setDescripcion(descripcion);
        evento.setEntradaStaff(entradaStaff);
        evento.setSalidaStaff(salidaStaff);
        evento.setEntradaGeneral(entradaPublico);
        evento.setSalidaGeneral(salidaPublico);
        evento.setFecha(fechaEvento);
        evento.setFkCuestionario(c);

        Evento eventoGuardado = repoEvento.save(evento);        

        return eventoGuardado.getId();
    }


    @Override
    public Evento registrarEventoDTO(EventoRequestDTO dto) {
        
        Cuestionario cuestionario = repoCuestionario.findById(dto.getCuestionarioId())
                .orElseThrow(() -> new RuntimeException("Cuestionario no encontrado"));

        Evento evento = new Evento();
        evento.setNombreEvento(dto.getNombreEvento());
        evento.setDescripcion(dto.getDescripcion());
        evento.setEntradaStaff(dto.getEntradaStaff());
        evento.setSalidaStaff(dto.getSalidaStaff());
        evento.setEntradaGeneral(dto.getEntradaGeneral());
        evento.setSalidaGeneral(dto.getSalidaGeneral());
        evento.setFecha(dto.getFecha());
        evento.setFkCuestionario(cuestionario);

        return repoEvento.save(evento);
    }
    
}

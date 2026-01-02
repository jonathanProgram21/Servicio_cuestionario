package com.servicio.cuestionario.Services;

import com.servicio.cuestionario.DTOs.EventoRequestDTO;
import com.servicio.cuestionario.entities.Evento;

public interface IEventoService {

    Long registrarEvento(
        Long cuestionarioId,
        String nombreEvento,
        String descripcion,
        String entradaStaff,
        String salidaStaff,
        String entradaPublico,
        String salidaPublico,
        String fechaEvento
    ); 

    Evento registrarEventoDTO(EventoRequestDTO dto);    
}

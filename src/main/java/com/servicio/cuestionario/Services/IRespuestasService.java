package com.servicio.cuestionario.Services;

import java.util.List;
import java.util.Map;

import com.servicio.cuestionario.DTOs.EstatusRespuestaDTO;
import com.servicio.cuestionario.DTOs.RespuestasRequestMapDTO;
import com.servicio.cuestionario.entities.Respuestas;

public interface IRespuestasService {

    
    void registrarRespuestas(
        Long eventoId,
        Map<Long, String> respuestas // preguntaId → respuesta (puede ser null)
    );

    void registrarRespuestasDTO(RespuestasRequestMapDTO dto);

    void actualizarRespuestasDTO(RespuestasRequestMapDTO dto);

    void actualizarEstatusRespuestasDTO(EstatusRespuestaDTO dto);

    List<Respuestas> obtenerTodasRespuestas(Long eventoId);

    

}

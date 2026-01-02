package com.servicio.cuestionario.Services;

import java.util.Map;

import com.servicio.cuestionario.DTOs.EstatusRespuestaDTO;
import com.servicio.cuestionario.DTOs.RespuestasRequestMapDTO;

public interface IRespuestasService {

    
    void registrarRespuestas(
        Long eventoId,
        Map<Long, String> respuestas // preguntaId → respuesta (puede ser null)
    );

    void registrarRespuestasDTO(RespuestasRequestMapDTO dto);

    void actualizarRespuestasDTO(RespuestasRequestMapDTO dto);

    void actualizarEstatusRespuestasDTO(EstatusRespuestaDTO dto);

    

}

package com.servicio.cuestionario.DTOs;

import java.util.Map;

public class RespuestasRequestMapDTO {
    
    private Long eventoId;
    private Map<Long, String> respuestas;

    public RespuestasRequestMapDTO() {
    }

    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public Map<Long, String> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(Map<Long, String> respuestas) {
        this.respuestas = respuestas;
    }

    


}

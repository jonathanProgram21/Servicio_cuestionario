package com.servicio.cuestionario.DTOs;

public class EstatusRespuestaDTO {
    private Long id_evento;
    private String estatus;

    public EstatusRespuestaDTO() {
    }

    public Long getId_evento() {
        return id_evento;
    }

    public void setId_evento(Long id_evento) {
        this.id_evento = id_evento;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    

}

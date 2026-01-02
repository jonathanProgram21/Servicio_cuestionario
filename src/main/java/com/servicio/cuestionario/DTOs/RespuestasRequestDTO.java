package com.servicio.cuestionario.DTOs;

public class RespuestasRequestDTO {
    
    private Long id;
    private String respuesta;
    private String estatus;
    private Long fkPregunta;
    private Long fkEvento;   

    public RespuestasRequestDTO(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Long getFkPregunta() {
        return fkPregunta;
    }

    public void setFkPregunta(Long fkPregunta) {
        this.fkPregunta = fkPregunta;
    }

    public Long getFkEvento() {
        return fkEvento;
    }

    public void setFkEvento(Long fkEvento) {
        this.fkEvento = fkEvento;
    }

    

}

package com.servicio.cuestionario.DTOs;

public class EventoRequestDTO {

    
    private Long cuestionarioId;
    private String nombreEvento;
    private String descripcion;
    private String entradaStaff;
    private String salidaStaff;
    private String entradaGeneral;
    private String salidaGeneral;
    private String fecha;

    public EventoRequestDTO() {
    }


    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEntradaStaff() {
        return entradaStaff;
    }

    public void setEntradaStaff(String entradaStaff) {
        this.entradaStaff = entradaStaff;
    }

    public String getSalidaStaff() {
        return salidaStaff;
    }

    public void setSalidaStaff(String salidaStaff) {
        this.salidaStaff = salidaStaff;
    }

    public String getEntradaGeneral() {
        return entradaGeneral;
    }

    public void setEntradaGeneral(String entradaGeneral) {
        this.entradaGeneral = entradaGeneral;
    }

    public String getSalidaGeneral() {
        return salidaGeneral;
    }

    public void setSalidaGeneral(String salidaGeneral) {
        this.salidaGeneral = salidaGeneral;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Long getCuestionarioId() {
        return cuestionarioId;
    }

    public void setCuestionarioId(Long fkCuestionario) {
        this.cuestionarioId = fkCuestionario;
    }
    

    
    
    
}

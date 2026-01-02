package com.servicio.cuestionario.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.servicio.cuestionario.DTOs.EstatusRespuestaDTO;
import com.servicio.cuestionario.DTOs.RespuestasRequestMapDTO;
import com.servicio.cuestionario.Repositories.RepoEvento;
import com.servicio.cuestionario.Repositories.RepoPregunta;
import com.servicio.cuestionario.Repositories.RepoRespuestas;
import com.servicio.cuestionario.entities.Estatus;
import com.servicio.cuestionario.entities.Evento;
import com.servicio.cuestionario.entities.Pregunta;
import com.servicio.cuestionario.entities.Respuestas;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class RespuestasServiceImpl implements IRespuestasService{

    private final RepoRespuestas repoRespuesta;
    private final RepoPregunta repoPregunta;
    private final RepoEvento repoEvento;

    //Constructor
    public RespuestasServiceImpl(RepoRespuestas repoRespuesta, RepoPregunta repoPregunta, RepoEvento repoEvento) {
        this.repoRespuesta = repoRespuesta;
        this.repoPregunta = repoPregunta;
        this.repoEvento = repoEvento;
    }

    @Override
    @Transactional
    public void registrarRespuestas(Long eventoId, Map<Long, String> respuestas) {
        
        Evento evento = repoEvento.findById(eventoId).orElseThrow(() -> new IllegalArgumentException("Evento no encontrado"));

        for (Map.Entry<Long, String> entry : respuestas.entrySet()) {

            Long preguntaId = entry.getKey();
            String textoRespuesta = entry.getValue(); // puede ser null

            Pregunta pregunta = repoPregunta.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));

            Respuestas respuesta = new Respuestas();
            respuesta.setFkPregunta(pregunta);
            respuesta.setFkEvento(evento);
            respuesta.setRespuesta(textoRespuesta); // ✔ null permitido
            respuesta.setEstatus(Estatus.EN_ESPERA);

            repoRespuesta.save(respuesta);
        }
        throw new UnsupportedOperationException("Unimplemented method 'registrarRespuestas'");
    }

    @Override
    @Transactional
    public void registrarRespuestasDTO(RespuestasRequestMapDTO dto) {
        
        Evento evento = repoEvento.findById(dto.getEventoId())
                .orElseThrow(() -> new RuntimeException("Evento no encontrado"));

        List<Respuestas> lista = new ArrayList<>();
        
        for (Map.Entry<Long, String> entry : dto.getRespuestas().entrySet()) {

            Long preguntaId = entry.getKey();
            String textoRespuesta = entry.getValue();

            Pregunta pregunta = repoPregunta.findById(preguntaId)
                .orElseThrow(() -> new RuntimeException("Pregunta no encontrada"));
            
            Respuestas respuesta = new Respuestas();

            respuesta.setFkPregunta(pregunta);
            respuesta.setFkEvento(evento);
            respuesta.setRespuesta(textoRespuesta);
            respuesta.setEstatus(Estatus.EN_ESPERA);

            lista.add(respuesta);

        }
        repoRespuesta.saveAll(lista);
    }


    @Override
    @Transactional
    public void actualizarRespuestasDTO(RespuestasRequestMapDTO dto) {

        Long eventoId = dto.getEventoId();

        for (Map.Entry<Long, String> entry : dto.getRespuestas().entrySet()) {

            Long preguntaId = entry.getKey();
            String nuevoTexto = entry.getValue();

            Respuestas respuesta = repoRespuesta
                    .findByFkEvento_IdAndFkPregunta_Id(eventoId, preguntaId)
                    .orElseThrow(() ->
                            new RuntimeException("Respuesta no encontrada para evento "
                                    + eventoId + " y pregunta " + preguntaId)
                    );

            respuesta.setRespuesta(nuevoTexto);
        }
    }


    @Override
    @Transactional
    public void actualizarEstatusRespuestasDTO(EstatusRespuestaDTO dto) {

        Long eventoId = dto.getId_evento();
        String estatus = dto.getEstatus();
        Estatus estatusEnum = Estatus.valueOf(estatus);        

        repoRespuesta.updateEstatusByEventoId(eventoId, estatusEnum);

    }



}

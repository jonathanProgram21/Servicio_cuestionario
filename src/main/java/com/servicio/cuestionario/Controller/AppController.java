package com.servicio.cuestionario.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicio.cuestionario.DTOs.EstatusRespuestaDTO;
import com.servicio.cuestionario.DTOs.EventoRequestDTO;
import com.servicio.cuestionario.DTOs.RespuestasRequestMapDTO;
import com.servicio.cuestionario.Services.IEventoService;
import com.servicio.cuestionario.Services.IRespuestasService;
import com.servicio.cuestionario.entities.Evento;
import com.servicio.cuestionario.entities.Respuestas;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/cuestionario")
public class AppController {

    private final IEventoService eventoService;
    private final IRespuestasService respuestasService;

    public AppController(IEventoService eventoService, IRespuestasService respuestasService) {
        this.eventoService = eventoService;
        this.respuestasService = respuestasService;
    }



    @PostMapping("/insertar/evento")
    public ResponseEntity<?> guardarEvento(@RequestBody EventoRequestDTO eventoDTO) {
        Evento guardarEvento = eventoService.registrarEventoDTO(eventoDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "Evento registrado correctamente",
                        "eventoId", guardarEvento.getId()));
        // return ResponseEntity.ok().build();
    }

    @PostMapping("/insertar/respuestas")
    public ResponseEntity<?> guardarRespuestas(@RequestBody RespuestasRequestMapDTO entity) {
        respuestasService.registrarRespuestasDTO(entity);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "Respuestas registradas correctamente"));
    }

    @PostMapping("/actualizar/respuestas")
    public ResponseEntity<?> actualizarRespuestas(@RequestBody RespuestasRequestMapDTO entity) {
        respuestasService.actualizarRespuestasDTO(entity);
        
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensaje", "Respuestas actualizadas correctamente"));
    }

    @PostMapping("/actualizar/estatusRespuestas")
    public ResponseEntity<?> actualizaEstatus(@RequestBody EstatusRespuestaDTO entity) {
        respuestasService.actualizarEstatusRespuestasDTO(entity);

        return ResponseEntity.status(HttpStatus.OK).body(Map.of("mensaje", "Estatus de respuestas actualizadas correctamente"));
    }

    @GetMapping("/respuestas/{eventoId}")
    public List<Respuestas> obtenerRespuestas(@PathVariable Long eventoId) {
        return respuestasService.obtenerTodasRespuestas(eventoId);
    }
    

    
    
    

    
    
}

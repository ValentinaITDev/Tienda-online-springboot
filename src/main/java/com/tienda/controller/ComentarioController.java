package com.tienda.controller;

import com.tienda.dto.ComentarioDTO;
import com.tienda.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {
    
    @Autowired
    private ComentarioService comentarioService;
    
    @GetMapping("/desde")
    public ResponseEntity<List<ComentarioDTO>> obtenerComentariosDesde(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        List<ComentarioDTO> comentarios = comentarioService.obtenerComentariosDesde(fecha);
        return ResponseEntity.ok(comentarios);
    }
}

package com.tienda.service.impl;

import com.tienda.dto.ComentarioDTO;
import com.tienda.entity.Comentario;
import com.tienda.repository.ComentarioRepository;
import com.tienda.service.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {
    
    @Autowired
    private ComentarioRepository comentarioRepository;
    
    @Override
    public List<ComentarioDTO> obtenerComentariosDesde(LocalDate fecha) {
        return comentarioRepository.findByFechaGreaterThanEqual(fecha).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    private ComentarioDTO convertirADTO(Comentario comentario) {
        return new ComentarioDTO(
            comentario.getIdComentario(),
            comentario.getProducto().getIdProducto(),
            comentario.getProducto().getNombre(),
            comentario.getUsuario().getIdUsuario(),
            comentario.getUsuario().getNombre(),
            comentario.getComentario(),
            comentario.getFecha()
        );
    }
}

package com.tienda.service;

import com.tienda.dto.ComentarioDTO;
import java.time.LocalDate;
import java.util.List;

public interface ComentarioService {
    List<ComentarioDTO> obtenerComentariosDesde(LocalDate fecha);
}

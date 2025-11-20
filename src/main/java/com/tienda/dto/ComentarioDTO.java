package com.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioDTO {
    private Long idComentario;
    private Long idProducto;
    private String nombreProducto;
    private Long idUsuario;
    private String nombreUsuario;
    private String comentario;
    private LocalDate fecha;
}

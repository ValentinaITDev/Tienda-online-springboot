package com.tienda.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {
    private Long idCarrito;
    private Long idUsuario;
    private String nombreUsuario;
    private List<ProductoDTO> productos;
    private Double subtotal;
    private Double impuestos;
    private Double total;
}

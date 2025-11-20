package com.tienda.service;

import com.tienda.dto.CarritoDTO;
import com.tienda.dto.ProductoDTO;
import java.util.List;

public interface CarritoService {
    CarritoDTO crearCarrito(String correoElectronico);
    CarritoDTO agregarProducto(Long idCarrito, Long idProducto, String correoElectronico);
    List<ProductoDTO> obtenerProductosDelCarrito(Long idCarrito, String correoElectronico);
}

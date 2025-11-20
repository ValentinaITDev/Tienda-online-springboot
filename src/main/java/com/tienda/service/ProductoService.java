package com.tienda.service;

import com.tienda.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {
    List<ProductoDTO> obtenerProductosBajoStock(int x);
}

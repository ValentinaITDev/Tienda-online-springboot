package com.tienda.service.impl;

import com.tienda.dto.ProductoDTO;
import com.tienda.entity.Producto;
import com.tienda.repository.ProductoRepository;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Override
    public List<ProductoDTO> obtenerProductosBajoStock(int x) {
        return productoRepository.findByStockLessThan(x).stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    
    private ProductoDTO convertirADTO(Producto producto) {
        return new ProductoDTO(
            producto.getIdProducto(),
            producto.getNombre(),
            producto.getDescripcion(),
            producto.getPrecio(),
            producto.getStock(),
            producto.getCategoria() != null ? producto.getCategoria().getNombre() : null
        );
    }
}

package com.tienda.controller;

import com.tienda.dto.ProductoDTO;
import com.tienda.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/bajo-stock")
    public ResponseEntity<List<ProductoDTO>> obtenerProductosBajoStock(@RequestParam int x) {
        List<ProductoDTO> productos = productoService.obtenerProductosBajoStock(x);
        return ResponseEntity.ok(productos);
    }
}

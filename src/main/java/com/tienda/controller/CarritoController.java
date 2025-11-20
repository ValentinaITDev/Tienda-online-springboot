package com.tienda.controller;

import com.tienda.dto.CarritoDTO;
import com.tienda.dto.ProductoDTO;
import com.tienda.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {
    
    @Autowired
    private CarritoService carritoService;
    
    @PostMapping
    public ResponseEntity<CarritoDTO> crearCarrito(Authentication authentication) {
        String correo = authentication.getName();
        CarritoDTO carrito = carritoService.crearCarrito(correo);
        return ResponseEntity.ok(carrito);
    }
    
    @PostMapping("/{id}/agregar-producto/{idProducto}")
    public ResponseEntity<CarritoDTO> agregarProducto(
            @PathVariable Long id,
            @PathVariable Long idProducto,
            Authentication authentication) {
        String correo = authentication.getName();
        CarritoDTO carrito = carritoService.agregarProducto(id, idProducto, correo);
        return ResponseEntity.ok(carrito);
    }
    
    @GetMapping("/{id}/productos")
    public ResponseEntity<List<ProductoDTO>> obtenerProductos(
            @PathVariable Long id,
            Authentication authentication) {
        String correo = authentication.getName();
        List<ProductoDTO> productos = carritoService.obtenerProductosDelCarrito(id, correo);
        return ResponseEntity.ok(productos);
    }
}

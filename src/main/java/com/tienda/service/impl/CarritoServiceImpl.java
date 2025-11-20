package com.tienda.service.impl;

import com.tienda.dto.CarritoDTO;
import com.tienda.dto.ProductoDTO;
import com.tienda.entity.CarritoDeCompras;
import com.tienda.entity.Producto;
import com.tienda.entity.Usuario;
import com.tienda.repository.CarritoRepository;
import com.tienda.repository.ProductoRepository;
import com.tienda.repository.UsuarioRepository;
import com.tienda.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarritoServiceImpl implements CarritoService {
    
    @Autowired
    private CarritoRepository carritoRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    private static final double IMPUESTO_PORCENTAJE = 0.19;
    
    @Override
    @Transactional
    public CarritoDTO crearCarrito(String correoElectronico) {
        Usuario usuario = usuarioRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        
        CarritoDeCompras carrito = new CarritoDeCompras();
        carrito.setUsuario(usuario);
        carrito.setSubtotal(0.0);
        carrito.setImpuestos(0.0);
        
        carrito = carritoRepository.save(carrito);
        return convertirADTO(carrito);
    }
    
    @Override
    @Transactional
    public CarritoDTO agregarProducto(Long idCarrito, Long idProducto, String correoElectronico) {
        CarritoDeCompras carrito = carritoRepository.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        
        if (!carrito.getUsuario().getCorreoElectronico().equals(correoElectronico)) {
            throw new RuntimeException("El carrito no pertenece al usuario autenticado");
        }
        
        Producto producto = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        
        if (producto.getStock() <= 0) {
            throw new RuntimeException("Producto sin stock disponible");
        }
        
        producto.setStock(producto.getStock() - 1);
        productoRepository.save(producto);
        
        carrito.getProductos().add(producto);
        
        double subtotal = carrito.getProductos().stream()
                .mapToDouble(Producto::getPrecio)
                .sum();
        double impuestos = subtotal * IMPUESTO_PORCENTAJE;
        
        carrito.setSubtotal(subtotal);
        carrito.setImpuestos(impuestos);
        
        carrito = carritoRepository.save(carrito);
        return convertirADTO(carrito);
    }
    
    @Override
    public List<ProductoDTO> obtenerProductosDelCarrito(Long idCarrito, String correoElectronico) {
        CarritoDeCompras carrito = carritoRepository.findById(idCarrito)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        
        if (!carrito.getUsuario().getCorreoElectronico().equals(correoElectronico)) {
            throw new RuntimeException("El carrito no pertenece al usuario autenticado");
        }
        
        return carrito.getProductos().stream()
                .map(this::convertirProductoADTO)
                .collect(Collectors.toList());
    }
    
    private CarritoDTO convertirADTO(CarritoDeCompras carrito) {
        List<ProductoDTO> productosDTO = carrito.getProductos().stream()
                .map(this::convertirProductoADTO)
                .collect(Collectors.toList());
        
        double total = carrito.getSubtotal() + carrito.getImpuestos();
        
        return new CarritoDTO(
            carrito.getIdCarrito(),
            carrito.getUsuario().getIdUsuario(),
            carrito.getUsuario().getNombre(),
            productosDTO,
            carrito.getSubtotal(),
            carrito.getImpuestos(),
            total
        );
    }
    
    private ProductoDTO convertirProductoADTO(Producto producto) {
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

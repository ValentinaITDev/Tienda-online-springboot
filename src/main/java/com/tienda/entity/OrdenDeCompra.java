package com.tienda.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ordenes_compra")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDeCompra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrden;
    
    @ManyToMany
    @JoinTable(
        name = "orden_productos",
        joinColumns = @JoinColumn(name = "id_orden"),
        inverseJoinColumns = @JoinColumn(name = "id_producto")
    )
    private List<Producto> productos = new ArrayList<>();
    
    @Column(nullable = false)
    private Double subtotal = 0.0;
    
    @Column(nullable = false)
    private Double impuestos = 0.0;
    
    @Column(nullable = false)
    private Double envio = 0.0;
    
    @Column(nullable = false)
    private Double total = 0.0;
}

package com.tienda.repository;

import com.tienda.entity.OrdenDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdenRepository extends JpaRepository<OrdenDeCompra, Long> {
}

package com.tienda.repository;

import com.tienda.entity.CarritoDeCompras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<CarritoDeCompras, Long> {
}

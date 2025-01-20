package com.miempresa.alquilervehiculos.repository;

import com.miempresa.alquilervehiculos.model.Alquiler;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlquilerRepository extends JpaRepository<Alquiler, Integer> {
    // Métodos adicionales como búsquedas por cliente, vehículo, fechas, etc.
}

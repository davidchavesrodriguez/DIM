package com.miempresa.alquilervehiculos.repository;

import com.miempresa.alquilervehiculos.model.Incidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidenteRepository extends JpaRepository<Incidente, Integer> {
    // Aquí puedes definir métodos personalizados si es necesario
}

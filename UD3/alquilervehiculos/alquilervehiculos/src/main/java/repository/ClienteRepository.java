package com.miempresa.alquilervehiculos.repository;

import com.miempresa.alquilervehiculos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    // Puedes agregar consultas personalizadas aquí si las necesitas
}

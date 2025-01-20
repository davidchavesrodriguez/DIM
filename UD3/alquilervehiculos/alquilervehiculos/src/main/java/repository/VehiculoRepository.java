package com.miempresa.alquilervehiculos.repository;

import com.miempresa.alquilervehiculos.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
    // Aquí también puedes agregar métodos personalizados si lo necesitas
}

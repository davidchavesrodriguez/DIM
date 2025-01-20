package com.miempresa.alquilervehiculos.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVehiculo;

    @Column(nullable = false, length = 10)
    private String matricula;

    @Column(nullable = false, length = 20)
    private String marca;

    @Column(nullable = false, length = 20)
    private String modelo;

    @Column(nullable = false)
    private Integer anoFabricacion;

    @Column(nullable = false, length = 20)
    private String estado;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Alquiler> alquileres;

    public Integer getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Integer idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoFabricacion() {
        return anoFabricacion;
    }

    public void setAnoFabricacion(Integer anoFabricacion) {
        this.anoFabricacion = anoFabricacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public void setAlquileres(List<Alquiler> alquileres) {
        this.alquileres = alquileres;
    }
}

package com.miempresa.alquilervehiculos.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Alquiler")
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAlquiler;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaTope;

    @Column(nullable = false)
    private Integer kilometrajeInicial;

    @Column
    private Integer kilometrajeFinal;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "idVehiculo", nullable = false)
    private Vehiculo vehiculo;

    @OneToMany(mappedBy = "alquiler", cascade = CascadeType.ALL)
    private List<Incidente> incidentes;

    public Integer getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(Integer idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTope() {
        return fechaTope;
    }

    public void setFechaTope(LocalDate fechaTope) {
        this.fechaTope = fechaTope;
    }

    public Integer getKilometrajeInicial() {
        return kilometrajeInicial;
    }

    public void setKilometrajeInicial(Integer kilometrajeInicial) {
        this.kilometrajeInicial = kilometrajeInicial;
    }

    public Integer getKilometrajeFinal() {
        return kilometrajeFinal;
    }

    public void setKilometrajeFinal(Integer kilometrajeFinal) {
        this.kilometrajeFinal = kilometrajeFinal;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Incidente> getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(List<Incidente> incidentes) {
        this.incidentes = incidentes;
    }
}

package com.miempresa.alquilervehiculos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Incidente")
public class Incidente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idIncidente;

    @Column(nullable = false, length = 255)
    private String daño;

    @Column(nullable = false)
    private Integer costes;

    @Column(nullable = false)
    private LocalDate fecha;

    @ManyToOne
    @JoinColumn(name = "idAlquiler", nullable = false)
    private Alquiler alquiler;

    public Integer getIdIncidente() {
        return idIncidente;
    }

    public void setIdIncidente(Integer idIncidente) {
        this.idIncidente = idIncidente;
    }

    public String getDaño() {
        return daño;
    }

    public void setDaño(String daño) {
        this.daño = daño;
    }

    public Integer getCostes() {
        return costes;
    }

    public void setCostes(Integer costes) {
        this.costes = costes;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Alquiler getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(Alquiler alquiler) {
        this.alquiler = alquiler;
    }
}

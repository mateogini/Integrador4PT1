package org.example.spring.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor

public class Monopatin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private boolean estado;
    @Column
    private double km_recorridos;
    @Column
    private long tiempoDeUso;
    @Column
    private double latitud;
    @Column
    private double longitud;
    @ManyToOne
    private Parada parada;
    public Monopatin(boolean estado, double km_recorridos, long tiempoDeUso, double latitud, double longitud) {
        this.estado = estado;
        this.km_recorridos = km_recorridos;
        this.tiempoDeUso = tiempoDeUso;
        this.latitud = latitud;
        this.longitud = longitud;

    }
}

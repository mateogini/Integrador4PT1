package org.example.spring.entidades;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long id_viaje;
    @Column
    private long id_usuario;
    @Column
    private long id_cuenta;
    @Column
    private long parada_inicio;
    @Column
    private long parada_fin;
    @Column
    private Date fechaHoraInicio;
    @Column
    private Date fechaHoraFin;
    @Column
    private double km_recorridos;
    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    // relaciono con monopatin
    @ManyToOne
    @JoinColumn(name = "idMonopatin")
    private Monopatin monopatin;

    @OneToMany(mappedBy = "viaje")
    private List<Pausa> pausas = new ArrayList<>();
    @Column
    private String tarifa_id;

    public Viaje(long id_viaje, long id_cuenta, long id_usuario, long parada_inicio, long parada_fin, Date fechaHoraInicio, Date fechaHoraFin, double km_recorridos, Usuario usuario, Monopatin monopatin, String tarifa) {
        this.id_viaje = id_viaje;
        this.id_cuenta = id_cuenta;
        this.id_usuario = id_usuario;
        this.parada_inicio = parada_inicio;
        this.parada_fin = parada_fin;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.km_recorridos = km_recorridos;
        this.usuario = usuario;
        this.monopatin = monopatin;
        this.tarifa_id = tarifa;
        this.pausas = new ArrayList<>();
    }
}

package org.example.spring.entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Pausa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private long id_viaje;
    @Column
    private Date fechaHoraInicio;
    @Column
    private Date fechaHoraFin;
    @ManyToOne
    @JoinColumn(name = "viaje")
    private Viaje viaje;

    public Pausa(long id_viaje, Date fechaHoraInicio, Date fechaHoraFin, Viaje viaje) {
        this.id_viaje = id_viaje;
        this.fechaHoraInicio = fechaHoraInicio;
        this.fechaHoraFin = fechaHoraFin;
        this.viaje = viaje;
    }
    public long getDuracion() {
        // Calcula la duración de la pausa en milisegundos
        if (fechaHoraInicio != null && fechaHoraFin != null) {
            return fechaHoraInicio.getTime() - fechaHoraFin.getTime();
        }
        return 0;
    }
}

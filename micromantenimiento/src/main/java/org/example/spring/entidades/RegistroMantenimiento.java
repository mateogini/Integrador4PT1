package org.example.spring.entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
@Data

public class RegistroMantenimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private Date fechaInicio;
    @Column
    private Date fechaFin;
    @Column
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "idMonopatin")
    private Monopatin monopatin;

    public RegistroMantenimiento( Date fechaInicio, Date fechaFin, String descripcion, Monopatin monopatin) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.descripcion = descripcion;
        this.monopatin = monopatin;
    }
}

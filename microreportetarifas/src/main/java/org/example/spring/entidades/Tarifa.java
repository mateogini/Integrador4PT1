package org.example.spring.entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor

public class Tarifa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private double monto;
    @Column
    private double monto_extra;
    @Column
    private Date fecha;


    public Tarifa(double monto, double montoExtra, Date fecha) {
        this.monto = monto;
        this.monto_extra = montoExtra;
        this.fecha = fecha;
    }
}

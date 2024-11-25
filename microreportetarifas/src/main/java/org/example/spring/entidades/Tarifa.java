package org.example.spring.entidades;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@Document(collection = "tarifas")
public class Tarifa {
    @Id
    private String id;
    private double monto;
    private double monto_extra;
    private Date fecha;


    public Tarifa(double monto, double montoExtra, Date fecha) {
        this.monto = monto;
        this.monto_extra = montoExtra;
        this.fecha = fecha;
    }
}

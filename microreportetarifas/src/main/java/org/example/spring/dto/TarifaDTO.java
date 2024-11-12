package org.example.spring.dto;
import org.example.spring.entidades.Tarifa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TarifaDTO {
    private double monto;
    private double montoExtra;
    private Date fecha;
    public TarifaDTO(Tarifa t){
        this.monto = t.getMonto();
        this.montoExtra = t.getMonto_extra();
        this.fecha = t.getFecha();
    }
}

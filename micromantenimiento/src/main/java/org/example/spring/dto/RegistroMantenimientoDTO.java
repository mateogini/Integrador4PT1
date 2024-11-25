package org.example.spring.dto;

import org.example.spring.entidades.Monopatin;
import org.example.spring.entidades.RegistroMantenimiento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistroMantenimientoDTO {
    private Date fechaInicio;
    private Date fechaFin;
    private String descripcion;
    private Monopatin monopatin;
    public RegistroMantenimientoDTO(RegistroMantenimiento rm){
        this.fechaInicio = rm.getFechaInicio();
        this.fechaFin = rm.getFechaFin();
        this.descripcion = rm.getDescripcion();
        this.monopatin = rm.getMonopatin();
    }
}

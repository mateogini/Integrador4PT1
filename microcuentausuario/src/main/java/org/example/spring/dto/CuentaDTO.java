package org.example.spring.dto;


import java.util.Date;

import org.example.spring.entidades.Cuenta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuentaDTO {
    private Date fecha_alta;
    private double saldo;
    private boolean estado;
    public CuentaDTO(Cuenta c){
        this.fecha_alta= c.getFecha_alta();
        this.saldo = c.getSaldo();
        this.estado = c.isEstado();
    }
}

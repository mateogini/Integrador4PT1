package org.example.spring.dto;
import org.example.spring.entidades.Pausa;
import org.example.spring.entidades.Viaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PausaDTO {
    private long id_viaje;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private Viaje viaje;

    public PausaDTO(Pausa p){
        this.id_viaje = p.getId_viaje();
        this.fechaHoraInicio = p.getFechaHoraInicio();
        this.fechaHoraFin = p.getFechaHoraFin();
        this.viaje = p.getViaje();
    }
}

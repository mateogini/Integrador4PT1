package org.example.spring.dto;

import org.example.spring.entidades.Monopatin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonopatinDTO {
    private boolean estado;
    private double km_recorridos;
    private long tiempoDeUso;
    private double latitud;
    private double longitud;
    public MonopatinDTO(Monopatin m){
        this.estado= m.isEstado();
        this.km_recorridos = m.getKm_recorridos();
        this.tiempoDeUso = m.getTiempoDeUso();
        this.latitud = m.getLatitud();
        this.longitud = m.getLongitud();

    }
}

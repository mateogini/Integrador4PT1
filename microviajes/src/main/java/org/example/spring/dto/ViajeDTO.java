package org.example.spring.dto;
import org.example.spring.entidades.Monopatin;
import org.example.spring.entidades.Tarifa;
import org.example.spring.entidades.Usuario;
import org.example.spring.entidades.Viaje;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class ViajeDTO {
    private long id_viaje;
    private long id_usuario;
    private long id_cuenta;
    private long id_monopatin;
    private long parada_inicio;
    private long parada_fin;
    private Date fechaHoraInicio;
    private Date fechaHoraFin;
    private double km_recorridos;
    private Usuario usuario;
    private Monopatin monopatin;
    private String tarifa_id;



    public ViajeDTO(Viaje v){
    this.id_viaje = v.getId_viaje();
    this.id_usuario = v.getId_usuario();
    this.id_cuenta = v.getId_cuenta();
    this.parada_inicio = v.getParada_inicio();
    this.parada_fin = v.getParada_fin();
    this.fechaHoraInicio = v.getFechaHoraInicio();
    this.fechaHoraFin = v.getFechaHoraFin();
    this.km_recorridos = v.getKm_recorridos();
    this.usuario = v.getUsuario();
    this.monopatin= v.getMonopatin();
    this.tarifa_id = v.getTarifa_id();
    }
}

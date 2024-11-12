package org.example.spring.dto;
import org.example.spring.entidades.Parada;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParadaDTO {
    private String ubicacion;
    private String nombre;
    public ParadaDTO(Parada p){
        this.ubicacion = p.getUbicacion();
        this.nombre = p.getNombre();
    }
}

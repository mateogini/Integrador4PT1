package org.example.spring.dto;

import org.example.spring.entidades.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private String nombre;
    private String apellido;
    private String email;
    private long telefono;
    public UsuarioDTO(Usuario u){
        this.nombre = u.getNombre();
        this.apellido = u.getApellido();
        this.email = u.getEmail();
        this.telefono = u.getTelefono();
    }

}

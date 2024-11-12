package org.example.spring.entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Parada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String ubicacion;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "parada")
    private Set<Monopatin> monopatines = new HashSet<>();

    public Parada(String ubicacion, String nombre) {
        this.ubicacion = ubicacion;
        this.nombre = nombre;
    }
}

package org.example.spring.entidades;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private Date fecha_alta;
    @Column
    private double saldo;
    @Column
    private boolean estado;

    @ManyToMany(mappedBy = "cuentas")
    private Set<Usuario> usuarios;


    public Cuenta(Date fecha_alta, double saldo, boolean estado) {
        this.fecha_alta = fecha_alta;
        this.saldo = saldo;
        this.estado = estado;
    }

}

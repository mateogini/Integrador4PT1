package org.example.spring.utils;

import org.example.spring.entidades.Usuario;
import org.example.spring.entidades.Cuenta;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.example.spring.repository.CuentaRepository;
import org.example.spring.repository.UsuarioRepository;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Slf4j

public class LoadDataBase {

    @Bean
    CommandLineRunner initDataBase(UsuarioRepository UsuarioRepository,
                                   CuentaRepository CuentaRepository) {
        return args -> {
            // Crear una cuenta
            Cuenta cuenta1 = new Cuenta();
            cuenta1.setSaldo(1000.0);
            cuenta1.setFecha_alta(new Date()); // Asignamos la fecha actual (Date)

            // Guardamos la cuenta
            CuentaRepository.save(cuenta1);

            // Crear un usuario y asociarlo con la cuenta
            Usuario u1 = new Usuario("Mateo", "Gini", "mateo@email.com", 1234567890);
            Set<Cuenta> u = new HashSet<>();
            u.add(cuenta1);
            u1.setCuentas(u);

            // Guardamos el usuario
            UsuarioRepository.save(u1);

            log.info("Datos cargados: Usuario " + u1.getNombre() + " " + u1.getApellido() + " con cuenta id: " + cuenta1.getId());
        };
    }

}

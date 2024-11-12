package org.example.spring.utils;


import lombok.extern.slf4j.Slf4j;
import org.example.spring.entidades.Monopatin;
import org.example.spring.entidades.RegistroMantenimiento;
import org.example.spring.repository.RegistroMantenimientoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDataBase(RegistroMantenimientoRepository registroMantenimientoRepository){
        return args -> {

            // Crear un registro de mantenimiento asociado al monopatin
            RegistroMantenimiento mantenimientoEjemplo = new RegistroMantenimiento(
                    new Date(),                               // fechaInicio
                    new Date(),                               // fechaFin
                    "Revisión completa y ajuste de frenos",
                    null
                                       // monopatin asociado
            );

            // Guardar el registro de mantenimiento en la base de datos
            registroMantenimientoRepository.save(mantenimientoEjemplo);

        };
    }
}

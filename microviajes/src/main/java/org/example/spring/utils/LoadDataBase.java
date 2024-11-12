package org.example.spring.utils;


import lombok.extern.slf4j.Slf4j;
import org.example.spring.entidades.*;
import org.example.spring.repository.PausaRepository;
import org.example.spring.repository.ViajeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDataBase(PausaRepository pausaRepository, ViajeRepository viajeRepository){
        return args -> {

            Viaje v = new Viaje(1,1,1,1,1, new Date(), new Date(), 200, null, null, null);
            viajeRepository.save(v);
            Pausa p = new Pausa(1, new Date(), new Date(), null);
            pausaRepository.save(p);
        };
    }
}

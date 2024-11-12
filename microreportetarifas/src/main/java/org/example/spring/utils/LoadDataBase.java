package org.example.spring.utils;


import lombok.extern.slf4j.Slf4j;
import org.example.spring.entidades.Tarifa;
import org.example.spring.repository.TarifaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

import java.util.Date;

@Configuration
@Slf4j
public class LoadDataBase {

    @Bean
    CommandLineRunner initDataBase(TarifaRepository tarifaRepository){
        return args -> {
        Tarifa t = new Tarifa(200.1, 20, new Date(2024, 12, 10));
        tarifaRepository.save(t);
        };
    }
}

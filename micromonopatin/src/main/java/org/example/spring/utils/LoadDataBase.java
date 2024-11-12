package org.example.spring.utils;


import lombok.extern.slf4j.Slf4j;
import org.example.spring.entidades.Monopatin;
import org.example.spring.entidades.Parada;
import org.example.spring.repository.MonopatinRepository;
import org.example.spring.repository.ParadaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadDataBase {
    @Bean
    CommandLineRunner initDataBase(MonopatinRepository monopatinRepository, ParadaRepository paradaRepository){
        return args -> {
            Parada paradaEjemplo = new Parada("Centro de la ciudad", "Parada Central");
            paradaRepository.save(paradaEjemplo);
            Monopatin m = new Monopatin(false, 2993.3, 100,20, 24);
            monopatinRepository.save(m);

        };

    }
}

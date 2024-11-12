package org.example.spring.repository;

import org.example.spring.entidades.Parada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParadaRepository extends JpaRepository<Parada,Long> {

}

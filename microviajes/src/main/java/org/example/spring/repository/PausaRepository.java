package org.example.spring.repository;

import org.example.spring.entidades.Pausa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PausaRepository extends JpaRepository<Pausa,Long> {
}

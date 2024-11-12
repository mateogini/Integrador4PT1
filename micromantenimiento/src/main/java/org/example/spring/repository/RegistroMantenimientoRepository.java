package org.example.spring.repository;

import org.example.spring.entidades.RegistroMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistroMantenimientoRepository extends JpaRepository<RegistroMantenimiento, Long> {
}

package org.example.spring.repository;

import org.example.spring.entidades.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    @Query("SELECT c FROM Cuenta c")
    public List<Cuenta> getCuentas();



}

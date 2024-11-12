package org.example.spring.repository;

import org.example.spring.entidades.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    @Query("SELECT SUM(f.monto + f.monto_extra) FROM Tarifa f " +
            "WHERE YEAR(f.fecha) = :anio " +
            "AND MONTH(f.fecha) BETWEEN :mesInicio AND :mesFin")
    public Double getTotalFacturadoEnRango(@Param("anio") int anio,
                                           @Param("mesInicio") int mesInicio,
                                           @Param("mesFin") int mesFin);


    Tarifa findFirstByFechaLessThanEqualOrderByFechaDesc(Date fecha);

}

package org.example.spring.repository;

import org.example.spring.entidades.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {
    @Query("SELECT v.monopatin.id FROM Viaje v WHERE v.fechaHoraFin BETWEEN :startDate AND :endDate " +
            "GROUP BY v.monopatin.id " +
            "HAVING COUNT(*) > :x")
    public List<Long> getXPorAnio(@Param("startDate") Date startDate,
                                  @Param("endDate") Date endDate,
                                  @Param("x") int x);

    @Query("SELECT m FROM Viaje m where m.monopatin.id = :idMonopatin")
    public List<Viaje> findByIdMonopatin(@Param("idMonopatin") long idMonopatin);

    @Query("SELECT distinct v.monopatin.id, v.km_recorridos FROM Viaje v ORDER BY v.km_recorridos DESC")
    List<Viaje> findAllViajesOrderByKm();


}

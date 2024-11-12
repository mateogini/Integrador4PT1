package org.example.spring.repository;

import org.example.spring.entidades.Monopatin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonopatinRepository extends JpaRepository<Monopatin, Long> {
    @Query("SELECT COUNT(m) FROM Monopatin m WHERE m.estado = true") // Estado = true asume que está en operación
    public long contarMonopatinesEnOperacion();

    @Query("SELECT COUNT(rm) FROM Monopatin rm WHERE rm.estado = false") // Considera solo los monopatines en operación
    public long contarMonopatinesEnMantenimiento();

    @Query("SELECT m FROM Monopatin m where m.latitud=:latitud AND m.longitud=:longitud")
    public List<Monopatin> finbyLocation(@Param("latitud") double latitud, @Param("longitud") double longitud);

}

package org.example.spring.repository;

import org.example.spring.entidades.Tarifa;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TarifaRepository extends MongoRepository<Tarifa, Long> {
    @Aggregation(pipeline = {
            "{ $match: { $expr: { $and: [ " +
                    "   { $eq: [{ $year: '$fecha' }, ?0] }, " +  // Filtra por el año especificado
                    "   { $gte: [{ $month: '$fecha' }, ?1] }, " + // Filtra por el mes de inicio
                    "   { $lte: [{ $month: '$fecha' }, ?2] } " +   // Filtra por el mes de fin
                    "] } } }",
            "{ $group: { _id: null, totalFacturado: { $sum: { $add: ['$monto', '$monto_extra'] } } } }"
    })
    double getTotalFacturadoEnRango(int anio, int mesInicio, int mesFin);




    Tarifa findFirstByFechaLessThanEqualOrderByFechaDesc(Date fecha);

}

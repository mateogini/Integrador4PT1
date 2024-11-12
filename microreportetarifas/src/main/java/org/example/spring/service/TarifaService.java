package org.example.spring.service;

import org.example.spring.dto.TarifaDTO;
import org.example.spring.entidades.Tarifa;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.spring.repository.TarifaRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TarifaService {

    private final TarifaRepository tarifaRepository;

    @Transactional
    public TarifaDTO guardarTarifa(TarifaDTO t) {
        var nuevaTarifa = new Tarifa(t.getMonto(), t.getMontoExtra(), t.getFecha());
        nuevaTarifa = tarifaRepository.save(nuevaTarifa);
        return new TarifaDTO(nuevaTarifa);
    }

    @Transactional
    public void eliminarTarifa(Long tarifaId) {
        tarifaRepository.deleteById(tarifaId);
    }

    @Transactional
    public TarifaDTO actualizarTarifa(Long tarifaId, TarifaDTO t) {
        var tarifaExistente = tarifaRepository.findById(tarifaId)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
        tarifaExistente.setMonto(t.getMonto());
        tarifaExistente.setMonto_extra(t.getMontoExtra());
        tarifaExistente.setFecha((t.getFecha()));
        tarifaRepository.save(tarifaExistente);
        return new TarifaDTO(tarifaExistente);
    }

    @Transactional
    public TarifaDTO getTarifaById(Long tarifaId) {
        var tarifa = tarifaRepository.findById(tarifaId)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
        return new TarifaDTO(tarifa);
    }

    // obtener todas las tarifas
    @Transactional
    public List<TarifaDTO> getAllTarifas() {
        return tarifaRepository.findAll().stream()
                .map(TarifaDTO::new)
                .collect(Collectors.toList());
    }
    // d. Como administrador quiero consultar el total facturado en un rango de meses de cierto año
    @Transactional
    public double getTotalFacturadoEnRango(int anio, int mesini, int mesfin){
        return tarifaRepository.getTotalFacturadoEnRango(anio,mesini,mesfin);

    }

    public Tarifa ajustarTarifa(String fechaAjuste, double nuevoMonto, double nuevoMontoExtra) {
        try {
            // Convertir la fecha de ajuste desde String a Date
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaAjuste);

            // Crear nueva tarifa con los datos proporcionados
            Tarifa nuevaTarifa = new Tarifa(nuevoMonto, nuevoMontoExtra, fecha);

            // Guardar la nueva tarifa en la base de datos
            tarifaRepository.save(nuevaTarifa);

            return nuevaTarifa;
        } catch (ParseException e) {
            throw new RuntimeException("Error al parsear la fecha: " + e.getMessage());
        }
    }
        public Tarifa obtenerTarifa(Date fechaViaje) {
            return tarifaRepository.findFirstByFechaLessThanEqualOrderByFechaDesc(fechaViaje);
        }



}

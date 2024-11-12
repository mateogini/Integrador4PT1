package org.example.spring.service;
import org.example.spring.dto.ViajeDTO;
import org.example.spring.dto.ViajeReporte;
import org.example.spring.entidades.Viaje;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.spring.repository.ViajeRepository;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ViajeService {
    private final ViajeRepository viajeRepository;

    @Transactional
    public ViajeDTO guardarViaje(ViajeDTO v) {
        var nuevoViaje = new Viaje(v.getId_viaje(), v.getId_cuenta(), v.getId_usuario(), v.getParada_inicio(),
                v.getParada_fin(), v.getFechaHoraInicio(), v.getFechaHoraFin(), v.getKm_recorridos(),
                v.getUsuario(), v.getMonopatin(), v.getTarifa());
        nuevoViaje = viajeRepository.save(nuevoViaje);
        return new ViajeDTO(nuevoViaje);
    }

    @Transactional
    public void eliminarViaje(Long viajeId) {
        viajeRepository.deleteById(viajeId);
    }

    @Transactional
    public ViajeDTO actualizarViaje(Long viajeId, ViajeDTO v) {
        var viajeExistente = viajeRepository.findById(viajeId)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));

        viajeExistente.setId_cuenta(v.getId_cuenta());
        viajeExistente.setId_usuario(v.getId_usuario());
        viajeExistente.setParada_inicio(v.getParada_inicio());
        viajeExistente.setParada_fin(v.getParada_fin());
        viajeExistente.setFechaHoraInicio(v.getFechaHoraInicio());
        viajeExistente.setFechaHoraFin(v.getFechaHoraFin());
        viajeExistente.setKm_recorridos(v.getKm_recorridos());
        viajeExistente.setUsuario(v.getUsuario());
        viajeExistente.setMonopatin(v.getMonopatin());
        viajeExistente.setTarifa(v.getTarifa());

        viajeRepository.save(viajeExistente);
        return new ViajeDTO(viajeExistente);
    }

    @Transactional
    public ViajeDTO getViajeById(Long viajeId) {
        var viaje = viajeRepository.findById(viajeId)
                .orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
        return new ViajeDTO(viaje);
    }

    // obtener todos los viajes
    @Transactional
    public List<ViajeDTO> getAllViajes() {
        return viajeRepository.findAll().stream()
                .map(ViajeDTO::new)
                .collect(Collectors.toList());
    }
    public List<Long> obtenerMonopatinesConMasDeXViajes(int anio, int x) {
        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();

        // Establece la fecha de inicio del año (1 de enero)
        calendarStart.set(anio, Calendar.JANUARY, 1, 0, 0, 0);
        calendarStart.set(Calendar.MILLISECOND, 0); // Elimina milisegundos para precisión

        // Establece la fecha de fin del año (31 de diciembre)
        calendarEnd.set(anio, Calendar.DECEMBER, 31, 23, 59, 59);
        calendarEnd.set(Calendar.MILLISECOND, 999); //

        // Obtiene las fechas como objetos Date
        Date startDate = calendarStart.getTime();
        Date endDate = calendarEnd.getTime();

        // Llama al repositorio con las fechas y el valor de x
        return viajeRepository.getXPorAnio(startDate, endDate, x);
    }

    public List<ViajeReporte> generarReporteUso(boolean incluirPausas) {
        // Obtener todos los viajes ordenados por kilómetros recorridos
        List<Viaje> viajes = viajeRepository.findAllViajesOrderByKm();

        // Procesar los viajes para obtener el reporte por monopatín
        return viajes.stream().map(viaje -> {
            // Calcular los kilómetros recorridos
            double kmRecorridos = viaje.getKm_recorridos();

            // Calcular el tiempo de uso con o sin pausas
            long tiempoDeUso = calcularTiempoDeUso(viaje, incluirPausas);

            // Retornar el reporte por cada viaje
            return new ViajeReporte(viaje.getMonopatin().getId(), kmRecorridos, tiempoDeUso);
        }).collect(Collectors.toList());
    }

    // Metodo que calcula el tiempo de uso de un viaje con o sin pausas
    private long calcularTiempoDeUso(Viaje viaje, boolean incluirPausas) {
        long tiempoDeUso = 0;

        // Verifica que las fechas de inicio y fin estén presentes
        if (viaje.getFechaHoraInicio() != null && viaje.getFechaHoraFin() != null) {
            // Calcular el tiempo de uso entre la fecha de inicio y la fecha de fin
            tiempoDeUso = viaje.getFechaHoraFin().getTime() - viaje.getFechaHoraInicio().getTime();
        }

        // Si se deben incluir las pausas, sumar su tiempo
        if (incluirPausas) {
            long tiempoPausas = viaje.getPausas().stream().mapToLong(pausa -> pausa.getDuracion()).sum();
            tiempoDeUso += tiempoPausas;
        }

        return tiempoDeUso;
    }


}

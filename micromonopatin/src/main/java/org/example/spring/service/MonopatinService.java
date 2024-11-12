package org.example.spring.service;

import org.example.spring.dto.MonopatinDTO;
import org.example.spring.entidades.Monopatin;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.spring.repository.MonopatinRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MonopatinService {

    private final MonopatinRepository monopatinRepository;

    @Transactional
    public MonopatinDTO guardarMonopatin(MonopatinDTO m) {
        var nuevoMonopatin = new Monopatin(m.isEstado(), m.getKm_recorridos(), m.getTiempoDeUso(), m.getLatitud(), m.getLongitud());
        nuevoMonopatin = monopatinRepository.save(nuevoMonopatin);
        return new MonopatinDTO(nuevoMonopatin);
    }

    @Transactional
    public void eliminarMonopatin(Long monopatinId) {
        monopatinRepository.deleteById(monopatinId);
    }

    @Transactional
    public MonopatinDTO actualizarMonopatin(Long monopatinId, MonopatinDTO m) {
        var monopatinExistente = monopatinRepository.findById(monopatinId)
                .orElseThrow(() -> new RuntimeException("Monopatín no encontrado"));
        monopatinExistente.setEstado(m.isEstado());
        monopatinExistente.setKm_recorridos(m.getKm_recorridos());
        monopatinExistente.setTiempoDeUso(m.getTiempoDeUso());
        monopatinExistente.setLatitud(m.getLatitud());
        monopatinExistente.setLongitud(m.getLongitud());
        monopatinRepository.save(monopatinExistente);
        return new MonopatinDTO(monopatinExistente);
    }

    @Transactional
    public MonopatinDTO getMonopatinById(Long monopatinId) {
        var monopatin = monopatinRepository.findById(monopatinId)
                .orElseThrow(() -> new RuntimeException("Monopatín no encontrado"));
        return new MonopatinDTO(monopatin);
    }

    //  obtener todos los monopatines
    @Transactional
    public List<MonopatinDTO> getAllMonopatines() {
        return monopatinRepository.findAll().stream()
                .map(MonopatinDTO::new)
                .collect(Collectors.toList());
    }
    //e. Como administrador quiero consultar la cantidad de monopatines actualmente en operación, versus la cantidad de monopatines actualmente en mantenimiento.
    @Transactional
    public Map<String, Long> obtenerEstadoMonopatines() {
            long enOperacion = monopatinRepository.contarMonopatinesEnOperacion();
            long enMantenimiento = monopatinRepository.contarMonopatinesEnMantenimiento();

            // resultados en un mapa para acceder facil
            Map<String, Long> estadoMonopatines = new HashMap<>();
            estadoMonopatines.put("enOperacion", enOperacion);
            estadoMonopatines.put("enMantenimiento", enMantenimiento);

            return estadoMonopatines;
        }
    @Transactional
    //g. Como usuario quiero lun listado de los monopatines cercanos a mi zona, para poder encontrar un monopatín cerca de mi ubicación
    public List<Monopatin> monopatinesCercanos(double latitud, double longitud){
        return monopatinRepository.finbyLocation(latitud, longitud);
    }

}
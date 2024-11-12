package org.example.spring.service;

import org.example.spring.dto.ParadaDTO;
import org.example.spring.entidades.Parada;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.spring.repository.ParadaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ParadaService {

    private final ParadaRepository paradaRepository;

    @Transactional
    public ParadaDTO guardarParada(ParadaDTO p) {
        var nuevaParada = new Parada(p.getUbicacion(), p.getNombre());
        nuevaParada = paradaRepository.save(nuevaParada);
        return new ParadaDTO(nuevaParada);
    }

    @Transactional
    public void eliminarParada(Long paradaId) {
        paradaRepository.deleteById(paradaId);
    }

    @Transactional
    public ParadaDTO actualizarParada(Long paradaId, ParadaDTO p) {
        var paradaExistente = paradaRepository.findById(paradaId)
                .orElseThrow(() -> new RuntimeException("Parada no encontrada"));
        paradaExistente.setUbicacion(p.getUbicacion());
        paradaExistente.setNombre(p.getNombre());
        paradaRepository.save(paradaExistente);
        return new ParadaDTO(paradaExistente);
    }

    @Transactional
    public ParadaDTO getParadaById(Long paradaId) {
        var parada = paradaRepository.findById(paradaId)
                .orElseThrow(() -> new RuntimeException("Parada no encontrada"));
        return new ParadaDTO(parada);
    }

    //  todas las paradas
    @Transactional
    public List<ParadaDTO> getAllParadas() {
        return paradaRepository.findAll().stream()
                .map(ParadaDTO::new)
                .collect(Collectors.toList());
    }
}

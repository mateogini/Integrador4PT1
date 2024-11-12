package org.example.spring.service;

import org.example.spring.dto.PausaDTO;
import org.example.spring.entidades.Pausa;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.spring.repository.PausaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PausaService {

    private final PausaRepository pausaRepository;

    @Transactional
    public PausaDTO guardarPausa(PausaDTO p) {
        var nuevaPausa = new Pausa(p.getId_viaje(), p.getFechaHoraInicio(), p.getFechaHoraFin(), p.getViaje());
        nuevaPausa = pausaRepository.save(nuevaPausa);
        return new PausaDTO(nuevaPausa);
    }

    @Transactional
    public void eliminarPausa(Long pausaId) {
        pausaRepository.deleteById(pausaId);
    }

    @Transactional
    public PausaDTO actualizarPausa(Long pausaId, PausaDTO p) {
        var pausaExistente = pausaRepository.findById(pausaId)
                .orElseThrow(() -> new RuntimeException("Pausa no encontrada"));
        pausaExistente.setFechaHoraInicio(p.getFechaHoraInicio());
        pausaExistente.setFechaHoraFin(p.getFechaHoraFin());
        pausaExistente.setViaje(p.getViaje());
        pausaRepository.save(pausaExistente);
        return new PausaDTO(pausaExistente);
    }

    @Transactional
    public PausaDTO getPausaById(Long pausaId) {
        var pausa = pausaRepository.findById(pausaId)
                .orElseThrow(() -> new RuntimeException("Pausa no encontrada"));
        return new PausaDTO(pausa);
    }

    // obtener todas las pausas
    @Transactional
    public List<PausaDTO> getAllPausas() {
        return pausaRepository.findAll().stream()
                .map(PausaDTO::new)
                .collect(Collectors.toList());
    }
}

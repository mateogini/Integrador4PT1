package org.example.spring.service;

import org.example.spring.dto.RegistroMantenimientoDTO;
import org.example.spring.entidades.RegistroMantenimiento;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.example.spring.repository.RegistroMantenimientoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegistroMantenimientoService {

    private final RegistroMantenimientoRepository registroMantenimientoRepository;

    @Transactional
    public List<RegistroMantenimiento> getAllMantenimientos(){
        return registroMantenimientoRepository.findAll();
    }

    @Transactional
    public RegistroMantenimientoDTO guardarManteminiento(RegistroMantenimientoDTO rmdto){
        var nuevomantenimineto = new RegistroMantenimiento(rmdto.getFechaInicio(), rmdto.getFechaFin(), rmdto.getDescripcion(), rmdto.getMonopatin());
        nuevomantenimineto = registroMantenimientoRepository.save(nuevomantenimineto);
        return new RegistroMantenimientoDTO(nuevomantenimineto);
    }

    @Transactional
    public void eliminarMantenimiento(Long mantenimientoId) {
        registroMantenimientoRepository.deleteById(mantenimientoId);
    }

    @Transactional
    public RegistroMantenimientoDTO actualizarMantenimiento(Long mantenimientoId, RegistroMantenimientoDTO rmdto) {
        var mantenimientoExistente = registroMantenimientoRepository.findById(mantenimientoId)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
        mantenimientoExistente.setFechaInicio(rmdto.getFechaInicio());
        mantenimientoExistente.setFechaFin(rmdto.getFechaFin());
        mantenimientoExistente.setDescripcion(rmdto.getDescripcion());
        registroMantenimientoRepository.save(mantenimientoExistente);
        return new RegistroMantenimientoDTO(mantenimientoExistente);
    }

    @Transactional
    public RegistroMantenimientoDTO getMantenimientoById(Long mantenimientoId) {
        var mantenimiento = registroMantenimientoRepository.findById(mantenimientoId)
                .orElseThrow(() -> new RuntimeException("Mantenimiento no encontrado"));
        return new RegistroMantenimientoDTO(mantenimiento);
    }
}

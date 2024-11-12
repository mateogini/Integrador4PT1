package org.example.spring.service;

import org.example.spring.dto.CuentaDTO;
import org.example.spring.entidades.Cuenta;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.example.spring.repository.CuentaRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CuentaService {
    @Autowired
    private final CuentaRepository cuentaRepository;

    @Transactional
    public CuentaDTO guardarCuenta(CuentaDTO cuentaDTO){
        // Convertir el DTO a entidad Cuenta

        var nuevaCuenta = new Cuenta(cuentaDTO.getFecha_alta(),cuentaDTO.getSaldo(), cuentaDTO.isEstado());

        //si pasa la validacion la guardo en la base
        nuevaCuenta = cuentaRepository.save(nuevaCuenta);

        return new CuentaDTO(nuevaCuenta);
    }
    @Transactional
    public List<Cuenta> getCuentas() {
        return cuentaRepository.getCuentas();
    }
    @Transactional
    public void eliminarCuenta(Long cuentaId) {
        cuentaRepository.deleteById(cuentaId);
    }

    @Transactional
    public CuentaDTO actualizarCuenta(Long cuentaId, CuentaDTO cuentaDTO) {
        var cuentaExistente = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
        cuentaExistente.setSaldo(cuentaDTO.getSaldo());
        cuentaExistente.setEstado(cuentaDTO.isEstado());
        cuentaRepository.save(cuentaExistente);
        return new CuentaDTO(cuentaExistente);
    }

    //b. metodo para anular una cuenta (cambiar su estado a 'false')

    @Transactional
    public CuentaDTO anularCuenta(Long cuentaId) {
        Cuenta c = cuentaRepository.findById(cuentaId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada"));;
        c.setEstado(false);
        c = cuentaRepository.save(c);
        return new CuentaDTO(c);

    }





}

package org.example.spring.controller;

import org.example.spring.dto.ParadaDTO;
import org.example.spring.service.ParadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/microMonopatin/paradas")
public class ParadaController {

    @Autowired
    private ParadaService paradaService;

    // Obtener todas las paradas
    @GetMapping("")
    public List<ParadaDTO> getAllParadas() {
        return paradaService.getAllParadas();
    }

    // Obtener una parada por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ParadaDTO> getParadaById(@PathVariable Long id) {
        ParadaDTO parada = paradaService.getParadaById(id);
        return ResponseEntity.ok(parada);
    }

    // Guardar una nueva parada
    @PostMapping("")
    public ResponseEntity<ParadaDTO> guardarParada(@RequestBody ParadaDTO paradaDTO) {
        ParadaDTO paradaGuardada = paradaService.guardarParada(paradaDTO);
        return ResponseEntity.status(201).body(paradaGuardada);
    }

    // Eliminar una parada por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarParada(@PathVariable Long id) {
        paradaService.eliminarParada(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar una parada por su ID
    @PutMapping("/{id}")
    public ResponseEntity<ParadaDTO> actualizarParada(@PathVariable Long id, @RequestBody ParadaDTO paradaDTO) {
        ParadaDTO updatedParada = paradaService.actualizarParada(id, paradaDTO);
        return ResponseEntity.ok(updatedParada);
    }
}

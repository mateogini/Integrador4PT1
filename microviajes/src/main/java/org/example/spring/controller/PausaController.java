package org.example.spring.controller;

import org.example.spring.dto.PausaDTO;
import org.example.spring.service.PausaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/microViajes/pausas")
public class PausaController {

    @Autowired
    private PausaService pausaService;

    // Obtener todas las pausas
    @GetMapping("")
    public List<PausaDTO> getAllPausas() {
        return pausaService.getAllPausas();
    }

    // Obtener una pausa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<PausaDTO> getPausaById(@PathVariable Long id) {
        PausaDTO pausa = pausaService.getPausaById(id);
        return ResponseEntity.ok(pausa);
    }

    // Guardar una nueva pausa
    @PostMapping("")
    public ResponseEntity<PausaDTO> guardarPausa(@RequestBody PausaDTO pausaDTO) {
        PausaDTO pausaGuardada = pausaService.guardarPausa(pausaDTO);
        return ResponseEntity.status(201).body(pausaGuardada);
    }

    // Eliminar una pausa por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPausa(@PathVariable Long id) {
        pausaService.eliminarPausa(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar una pausa por su ID
    @PutMapping("/{id}")
    public ResponseEntity<PausaDTO> actualizarPausa(@PathVariable Long id, @RequestBody PausaDTO pausaDTO) {
        PausaDTO updatedPausa = pausaService.actualizarPausa(id, pausaDTO);
        return ResponseEntity.ok(updatedPausa);
    }

}

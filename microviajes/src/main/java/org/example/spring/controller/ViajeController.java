package org.example.spring.controller;

import org.example.spring.dto.ViajeDTO;
import org.example.spring.dto.ViajeReporte;
import org.example.spring.service.ViajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "viajes")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    // Obtener todos los viajes
    @GetMapping("")
    public List<ViajeDTO> getAllViajes() {
        return viajeService.getAllViajes();
    }

    // Obtener un viaje por su ID
    @GetMapping("/{id}")
    public ResponseEntity<ViajeDTO> getViajeById(@PathVariable Long id) {
        ViajeDTO viaje = viajeService.getViajeById(id);
        return ResponseEntity.ok(viaje);
    }

    // Guardar un nuevo viaje
    @PostMapping("")
    public ResponseEntity<ViajeDTO> guardarViaje(@RequestBody ViajeDTO viajeDTO) {
        ViajeDTO viajeGuardado = viajeService.guardarViaje(viajeDTO);
        return ResponseEntity.status(201).body(viajeGuardado);
    }

    // Eliminar un viaje por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarViaje(@PathVariable Long id) {
        viajeService.eliminarViaje(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un viaje por su ID
    @PutMapping("/{id}")
    public ResponseEntity<ViajeDTO> actualizarViaje(@PathVariable Long id, @RequestBody ViajeDTO viajeDTO) {
        ViajeDTO updatedViaje = viajeService.actualizarViaje(id, viajeDTO);
        return ResponseEntity.ok(updatedViaje);
    }
    //c. Como administrador quiero consultar los monopatines con más de X viajes en un cierto año.
    @GetMapping("/viajes/{x}/anio/{anio}")
    public List<Long> getMonopatinesConMasDeXVViajes(@PathVariable int anio, @PathVariable int x) {
        return viajeService.obtenerMonopatinesConMasDeXViajes(anio, x);
    }

    @GetMapping("/reporte")
    public List<ViajeReporte> generarReporte(@RequestParam(defaultValue = "false") boolean incluirPausas) {
        return viajeService.generarReporteUso(incluirPausas);
    }

}

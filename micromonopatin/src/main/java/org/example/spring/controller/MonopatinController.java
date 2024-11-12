package org.example.spring.controller;

import org.example.spring.dto.MonopatinDTO;
import org.example.spring.entidades.Monopatin;
import org.example.spring.service.MonopatinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "monopatines")
public class MonopatinController {

    @Autowired
    private MonopatinService monopatinService;

    // Obtener todos los monopatines
    @GetMapping("")
    public List<MonopatinDTO> getAllMonopatines() {
        return monopatinService.getAllMonopatines();
    }

    // Obtener un monopatín por su ID
    @GetMapping("/{id}")
    public ResponseEntity<MonopatinDTO> getMonopatinById(@PathVariable Long id) {
        MonopatinDTO monopatin = monopatinService.getMonopatinById(id);
        return ResponseEntity.ok(monopatin);
    }

    // Guardar un nuevo monopatín
    @PostMapping("")
    public ResponseEntity<MonopatinDTO> guardarMonopatin(@RequestBody MonopatinDTO monopatinDTO) {
        MonopatinDTO monopatinGuardado = monopatinService.guardarMonopatin(monopatinDTO);
        return ResponseEntity.status(201).body(monopatinGuardado);
    }

    // Eliminar un monopatín por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMonopatin(@PathVariable Long id) {
        monopatinService.eliminarMonopatin(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un monopatín por su ID
    @PutMapping("/{id}")
    public ResponseEntity<MonopatinDTO> actualizarMonopatin(@PathVariable Long id, @RequestBody MonopatinDTO monopatinDTO) {
        MonopatinDTO updatedMonopatin = monopatinService.actualizarMonopatin(id, monopatinDTO);
        return ResponseEntity.ok(updatedMonopatin);
    }
   // e. Como administrador quiero consultar la cantidad de monopatines actualmente en operación,versus la cantidad de monopatines actualmente en mantenimiento
    @GetMapping("/estado")
    public Map<String, Long> obtenerEstadoMonopatines() {
        return monopatinService.obtenerEstadoMonopatines();
    }
    //g. Como usuario quiero lun listado de los monopatines cercanos a mi zona, para poder encontrar un monopatín cerca de mi ubicación
    @GetMapping("/cercanos/latitud/{lat}/longitud/{longi}")
    public List<Monopatin> monopatinesCercanos(@PathVariable double lat, @PathVariable double longi){
        return monopatinService.monopatinesCercanos(lat,longi);
    }

}

package org.example.spring.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.example.spring.dto.RegistroMantenimientoDTO;
import org.example.spring.entidades.RegistroMantenimiento;
import org.example.spring.service.RegistroMantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/microMantenimiento/mantenimientos")
public class RegistroMantenimientoController {

    @Autowired
    private RegistroMantenimientoService registroMantenimientoService;

    @Operation(summary = "Traer mantenimientos", description = "Este endpoint trae todos los mantenimientos.")
    @ApiResponse(responseCode = "200", description = "Lista de mantenimientos")
    // Obtener todos los mantenimientos
    @GetMapping("")
    public List<RegistroMantenimiento> getAllMantenimientos() {
        // Agregar un metodo en el servicio para obtener todos los mantenimientos
        return registroMantenimientoService.getAllMantenimientos();
    }
    @Operation(summary = "Traer un mantenimiento", description = "Este endpoint trae un mantenimiento por id.")
    @ApiResponse(responseCode = "200", description = "Mantenimiento correspondiente al id")
    // Obtener un mantenimiento por su ID
    @GetMapping("/{id}")
    public ResponseEntity<RegistroMantenimientoDTO> getMantenimientoById(@PathVariable Long id) {
        RegistroMantenimientoDTO mantenimiento = registroMantenimientoService.getMantenimientoById(id);
        return ResponseEntity.ok(mantenimiento);
    }
    @Operation(summary = "Crear nuevo mantimiento", description = "Este endpoint crea un nuevo mantenimiento.")
    @ApiResponse(responseCode = "201", description = "Mantenimiento creado")
    // Guardar un nuevo mantenimiento
    @PostMapping("")
    public ResponseEntity<RegistroMantenimientoDTO> guardarMantenimiento(@RequestBody RegistroMantenimientoDTO mantenimientoDTO) {
        RegistroMantenimientoDTO mantenimientoGuardado = registroMantenimientoService.guardarManteminiento(mantenimientoDTO);
        return ResponseEntity.status(201).body(mantenimientoGuardado);
    }

    // Eliminar un mantenimiento por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMantenimiento(@PathVariable Long id) {
        registroMantenimientoService.eliminarMantenimiento(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un mantenimiento por su ID
    @PutMapping("/{id}")
    public ResponseEntity<RegistroMantenimientoDTO> actualizarMantenimiento(@PathVariable Long id, @RequestBody RegistroMantenimientoDTO mantenimientoDTO) {
        RegistroMantenimientoDTO updatedMantenimiento = registroMantenimientoService.actualizarMantenimiento(id, mantenimientoDTO);
        return ResponseEntity.ok(updatedMantenimiento);
    }
}

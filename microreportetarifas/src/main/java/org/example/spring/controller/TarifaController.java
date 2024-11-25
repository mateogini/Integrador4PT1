package org.example.spring.controller;

import org.example.spring.dto.TarifaDTO;
import org.example.spring.entidades.Tarifa;
import org.example.spring.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/api/microTarifas/tarifas")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    // Obtener todas las tarifas
    @GetMapping("")
    public List<TarifaDTO> getAllTarifas() {
        return tarifaService.getAllTarifas();
    }

    // Obtener una tarifa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<TarifaDTO> getTarifaById(@PathVariable Long id) {
        TarifaDTO tarifa = tarifaService.getTarifaById(id);
        return ResponseEntity.ok(tarifa);
    }

    // Guardar una nueva tarifa
    @PostMapping("")
    public ResponseEntity<TarifaDTO> guardarTarifa(@RequestBody TarifaDTO tarifaDTO) {
        TarifaDTO tarifaGuardada = tarifaService.guardarTarifa(tarifaDTO);
        return ResponseEntity.status(201).body(tarifaGuardada);
    }

    // Eliminar una tarifa por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarifa(@PathVariable Long id) {
        tarifaService.eliminarTarifa(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar una tarifa por su ID
    @PutMapping("/{id}")
    public ResponseEntity<TarifaDTO> actualizarTarifa(@PathVariable Long id, @RequestBody TarifaDTO tarifaDTO) {
        TarifaDTO updatedTarifa = tarifaService.actualizarTarifa(id, tarifaDTO);
        return ResponseEntity.ok(updatedTarifa);
    }
    //d. d. Como administrador quiero consultar el total facturado en un rango de meses de cierto año.
    @GetMapping("/totalfacturado/anio/{anio}/mesinicio/{ini}/mesfin/{fin}")
    public double getTotalFacturado(@PathVariable int anio, @PathVariable int ini, @PathVariable int fin){
        return tarifaService.getTotalFacturadoEnRango(anio, ini, fin);
    }

    //f. Como administrador quiero hacer un ajuste de precios, y que a partir de cierta fecha el sistema habilite los nuevos precios
    @PostMapping("/ajustar/precionuevo/{nuevoMonto}/montoextra/{montoextra}")
    public String ajustarTarifas(@PathVariable String fechaAjuste, @PathVariable double nuevoMonto, @PathVariable double nuevoMontoExtra) {
        Tarifa nuevaTarifa = tarifaService.ajustarTarifa(fechaAjuste, nuevoMonto, nuevoMontoExtra);
        return "Tarifa ajustada exitosamente. Nueva tarifa ID: " + nuevaTarifa.getId();
    }

    // obtener la tarifa de un viaje
    @GetMapping("/tarifa-viaje")
    public Tarifa obtenerTarifa(@PathVariable String fechaViaje) {
        try {
            Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(fechaViaje);
            return tarifaService.obtenerTarifa(fecha);
        } catch (Exception e) {
            throw new RuntimeException("Error al obtener tarifa: " + e.getMessage());
        }
    }
}

package org.example.spring.controller;


import org.example.spring.dto.CuentaDTO;
import org.example.spring.entidades.Cuenta;
import org.example.spring.service.CuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="cuentas")
public class CuentaController {
    @Autowired
    private CuentaService cuentaService;

    @GetMapping("")
    public List<Cuenta> gettAllCuentas(){
        return this.cuentaService.getCuentas();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCuenta(@PathVariable Long id) {
        cuentaService.eliminarCuenta(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CuentaDTO> actualizarCuenta(@PathVariable Long id, @RequestBody CuentaDTO cuentaDTO) {
        CuentaDTO updatedCuenta = cuentaService.actualizarCuenta(id, cuentaDTO);
        return ResponseEntity.ok(updatedCuenta);
    }
    @PostMapping("")
    public CuentaDTO guardarCuenta(@RequestBody CuentaDTO cuentaDTO) {
        return guardarCuenta(cuentaDTO);
    }

    // metodo para anular una cuenta (cambiar su estado a 'false')
    @PutMapping("/anular/{id}")
    public ResponseEntity<CuentaDTO> anularCuenta(@PathVariable Long id) {
        CuentaDTO cuentaAnulada = cuentaService.anularCuenta(id);
        return ResponseEntity.ok(cuentaAnulada);
    }
}

package org.example.spring.controller;


import org.example.spring.dto.UsuarioDTO;
import org.example.spring.service.UsuarioService;
import org.example.spring.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/microcuentaUsuarios/users")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;



    // Obtener todos los usuarios
    @GetMapping("")
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getUsuarios();
    }

    // Obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        UsuarioDTO usuario = usuarioService.getUsuarioById(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("")
    public ResponseEntity<UsuarioDTO> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO usuarioGuardado = usuarioService.guardarUsuario(usuarioDTO);
        return ResponseEntity.status(201).body(usuarioGuardado);
    }

    // Eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    // Actualizar un usuario por su ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioDTO updatedUsuario = usuarioService.actualizarUsuario(id, usuarioDTO);
        return ResponseEntity.ok(updatedUsuario);
    }
}

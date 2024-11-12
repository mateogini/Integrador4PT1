package org.example.spring.service;

import org.example.spring.dto.UsuarioDTO;
import org.example.spring.entidades.Usuario;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.spring.repository.UsuarioRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    @Autowired
    private final UsuarioRepository usuarioRepository;
    @Transactional
    public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO){
        var nuevoUsuario = new Usuario(usuarioDTO.getNombre(),usuarioDTO.getApellido(),usuarioDTO.getEmail(),usuarioDTO.getTelefono());

        nuevoUsuario = usuarioRepository.save(nuevoUsuario);

        return new UsuarioDTO((nuevoUsuario));

    }

    @Transactional
    public void eliminarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    @Transactional
    public UsuarioDTO actualizarUsuario(Long usuarioId, UsuarioDTO usuarioDTO) {
        var usuarioExistente = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        usuarioExistente.setNombre(usuarioDTO.getNombre());
        usuarioExistente.setApellido(usuarioDTO.getApellido());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setTelefono(usuarioDTO.getTelefono());
        usuarioRepository.save(usuarioExistente);
        return new UsuarioDTO(usuarioExistente);
    }

    @Transactional
    public UsuarioDTO getUsuarioById(Long usuarioId) {
        var usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return new UsuarioDTO(usuario);
    }

    //  metodo para obtener todos los usuarios
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }
}

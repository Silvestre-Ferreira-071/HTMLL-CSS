package com.example.rev.service;

import com.example.rev.exception.EmailCadastradoException;
import com.example.rev.model.Usuario;
import com.example.rev.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> ListarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new EmailCadastradoException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }
}

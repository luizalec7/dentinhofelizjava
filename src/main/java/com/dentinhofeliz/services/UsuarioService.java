package com.dentinhofeliz.services;

import com.dentinhofeliz.dto.UsuarioDTO;
import com.dentinhofeliz.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    private List<Usuario> usuarios = new ArrayList<>();

    public List<Usuario> listarTodos() {
        return usuarios;
    }

    public Usuario criarUsuario(UsuarioDTO usuarioDTO) {
        Usuario novoUsuario = new Usuario();
        novoUsuario.setId(usuarioDTO.getId());
        novoUsuario.setNome(usuarioDTO.getNome());
        novoUsuario.setEmail(usuarioDTO.getEmail());
        usuarios.add(novoUsuario);
        return novoUsuario;
    }
}

package com.dentinhofeliz.controllers;

import com.dentinhofeliz.dto.UsuarioDTO;
import com.dentinhofeliz.entities.Usuario;
import com.dentinhofeliz.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<EntityModel<Usuario>> listarUsuarios() {
        return usuarioService.listarTodos().stream()
                .map(usuario -> EntityModel.of(usuario,
                        linkTo(methodOn(UsuarioController.class).listarUsuario(usuario.getId())).withSelfRel(),
                        linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Usuario> listarUsuario(@PathVariable Long id) {
        Usuario usuario = usuarioService.buscarPorId(id);
        return EntityModel.of(usuario,
                linkTo(methodOn(UsuarioController.class).listarUsuario(id)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios"));
    }

    @PostMapping
    public EntityModel<Usuario> criarUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioService.criarUsuario(usuarioDTO);
        return EntityModel.of(usuario,
                linkTo(methodOn(UsuarioController.class).listarUsuario(usuario.getId())).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).listarUsuarios()).withRel("usuarios"));
    }
}

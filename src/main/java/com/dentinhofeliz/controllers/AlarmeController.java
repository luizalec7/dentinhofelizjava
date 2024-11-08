package com.dentinhofeliz.controllers;

import com.dentinhofeliz.dto.AlarmeDTO;
import com.dentinhofeliz.entities.Alarme;
import com.dentinhofeliz.services.AlarmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/alarmes")
public class AlarmeController {

    @Autowired
    private AlarmeService alarmeService;

    @GetMapping
    public List<EntityModel<Alarme>> listarAlarmes() {
        return alarmeService.listarTodos().stream()
                .map(alarme -> EntityModel.of(alarme,
                        linkTo(methodOn(AlarmeController.class).listarAlarme(alarme.getId())).withSelfRel(),
                        linkTo(methodOn(AlarmeController.class).listarAlarmes()).withRel("alarmes")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Alarme> listarAlarme(@PathVariable Long id) {
        Alarme alarme = alarmeService.buscarPorId(id);
        return EntityModel.of(alarme,
                linkTo(methodOn(AlarmeController.class).listarAlarme(id)).withSelfRel(),
                linkTo(methodOn(AlarmeController.class).listarAlarmes()).withRel("alarmes"));
    }

    @PostMapping
    public EntityModel<Alarme> criarAlarme(@RequestBody AlarmeDTO alarmeDTO) {
        Alarme alarme = alarmeService.criarAlarme(alarmeDTO);
        return EntityModel.of(alarme,
                linkTo(methodOn(AlarmeController.class).listarAlarme(alarme.getId())).withSelfRel(),
                linkTo(methodOn(AlarmeController.class).listarAlarmes()).withRel("alarmes"));
    }
}

package com.dentinhofeliz.controllers;

import com.dentinhofeliz.dto.AlarmeDTO;
import com.dentinhofeliz.entities.Alarme;
import com.dentinhofeliz.services.AlarmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alarmes")
public class AlarmeController {

    @Autowired
    private AlarmeService alarmeService;

    @GetMapping
    public List<Alarme> listarAlarmes() {
        return alarmeService.listarTodos();
    }

    @PostMapping
    public Alarme criarAlarme(@RequestBody AlarmeDTO alarmeDTO) {
        return alarmeService.criarAlarme(alarmeDTO);
    }
}

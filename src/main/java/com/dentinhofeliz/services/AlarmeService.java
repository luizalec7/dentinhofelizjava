package com.dentinhofeliz.services;

import com.dentinhofeliz.dto.AlarmeDTO;
import com.dentinhofeliz.entities.Alarme;
import com.dentinhofeliz.repositories.AlarmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmeService {

    @Autowired
    private AlarmeRepository alarmeRepository;

    public List<Alarme> listarTodos() {
        return alarmeRepository.findAll();
    }

    public Alarme criarAlarme(AlarmeDTO alarmeDTO) {
        Alarme alarme = new Alarme();
        alarme.setHora(alarmeDTO.getHora());
        return alarmeRepository.save(alarme);
    }
}

package com.dentinhofeliz.services;

import com.dentinhofeliz.dto.AlarmeDTO;
import com.dentinhofeliz.entities.Alarme;
import com.dentinhofeliz.repositories.AlarmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlarmeService {

    @Autowired
    private AlarmeRepository alarmeRepository;

    public List<Alarme> listarTodos() {
        return alarmeRepository.findAll();
    }

    public Alarme criarAlarme(AlarmeDTO alarmeDTO) {
        Alarme novoAlarme = new Alarme();
        novoAlarme.setHora(alarmeDTO.getHora());
        return alarmeRepository.save(novoAlarme);
    }

    public Alarme buscarPorId(Long id) {
        Optional<Alarme> alarme = alarmeRepository.findById(id);
        return alarme.orElseThrow(() -> new RuntimeException("Alarme não encontrado"));
    }
}

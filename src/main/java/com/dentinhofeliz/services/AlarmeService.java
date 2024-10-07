package com.dentinhofeliz.services;

import com.dentinhofeliz.dto.AlarmeDTO;
import com.dentinhofeliz.entities.Alarme;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class AlarmeService {

    private List<Alarme> alarmes = new ArrayList<>();

    public List<Alarme> listarTodos() {
        return alarmes;
    }

    public Alarme criarAlarme(AlarmeDTO alarmeDTO) {
        Alarme novoAlarme = new Alarme();
        novoAlarme.setId(alarmeDTO.getId());
        novoAlarme.setHora(alarmeDTO.getHora());
        alarmes.add(novoAlarme);
        return novoAlarme;
    }
}

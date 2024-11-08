package com.dentinhofeliz.controllers;

import com.dentinhofeliz.dto.RespostaDTO;
import com.dentinhofeliz.services.RespostaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/respostas")
public class RespostaController {

    @Autowired
    private RespostaService respostaService;

    @PostMapping
    public RespostaDTO criarResposta(@RequestBody RespostaDTO respostaDTO) {
        return respostaService.toRespostaDTO(respostaService.criarResposta(respostaDTO));
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<RespostaDTO> listarRespostasPorUsuario(@PathVariable Long usuarioId) {
        return respostaService.listarRespostasPorUsuario(usuarioId).stream()
                .map(respostaService::toRespostaDTO)
                .collect(Collectors.toList());
    }
}

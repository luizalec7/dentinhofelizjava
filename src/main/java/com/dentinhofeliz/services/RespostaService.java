package com.dentinhofeliz.services;

import com.dentinhofeliz.dto.RespostaDTO;
import com.dentinhofeliz.entities.Quiz;
import com.dentinhofeliz.entities.Resposta;
import com.dentinhofeliz.entities.Usuario;
import com.dentinhofeliz.repositories.QuizRepository;
import com.dentinhofeliz.repositories.RespostaRepository;
import com.dentinhofeliz.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Resposta criarResposta(RespostaDTO respostaDTO) {
        Usuario usuario = usuarioRepository.findById(respostaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Quiz quiz = quizRepository.findById(respostaDTO.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz não encontrado"));

        Resposta resposta = new Resposta();
        resposta.setUsuario(usuario);
        resposta.setQuiz(quiz);
        resposta.setRespostaUsuario(respostaDTO.getRespostaUsuario());
        resposta.setCorreta(quiz.getRespostaCorreta().equalsIgnoreCase(respostaDTO.getRespostaUsuario()));

        return respostaRepository.save(resposta);
    }

    public List<Resposta> listarRespostasPorUsuario(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return respostaRepository.findByUsuario(usuario);
    }

    public RespostaDTO toRespostaDTO(Resposta resposta) {
        RespostaDTO dto = new RespostaDTO();
        dto.setId(resposta.getId());
        dto.setUsuarioId(resposta.getUsuario().getId());
        dto.setQuizId(resposta.getQuiz().getId());
        dto.setRespostaUsuario(resposta.getRespostaUsuario());
        dto.setCorreta(resposta.isCorreta());
        return dto;
    }

    public Resposta toResposta(RespostaDTO respostaDTO) {
        Resposta resposta = new Resposta();
        Usuario usuario = usuarioRepository.findById(respostaDTO.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        Quiz quiz = quizRepository.findById(respostaDTO.getQuizId())
                .orElseThrow(() -> new RuntimeException("Quiz não encontrado"));

        resposta.setUsuario(usuario);
        resposta.setQuiz(quiz);
        resposta.setRespostaUsuario(respostaDTO.getRespostaUsuario());
        resposta.setCorreta(quiz.getRespostaCorreta().equalsIgnoreCase(respostaDTO.getRespostaUsuario()));
        return resposta;
    }
}

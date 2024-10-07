package com.dentinhofeliz.services;

import com.dentinhofeliz.dto.QuizDTO;
import com.dentinhofeliz.entities.Quiz;
import com.dentinhofeliz.repositories.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepository quizRepository;

    public List<Quiz> listarTodos() {
        return quizRepository.findAll();
    }

    public Quiz criarQuiz(QuizDTO quizDTO) {
        Quiz quiz = new Quiz();
        quiz.setPergunta(quizDTO.getPergunta());
        quiz.setRespostaCorreta(quizDTO.getRespostaCorreta());
        return quizRepository.save(quiz);
    }
}

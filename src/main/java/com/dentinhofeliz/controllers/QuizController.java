package com.dentinhofeliz.controllers;

import com.dentinhofeliz.dto.QuizDTO;
import com.dentinhofeliz.entities.Quiz;
import com.dentinhofeliz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<Quiz> listarQuizzes() {
        return quizService.listarTodos();
    }

    @PostMapping
    public Quiz criarQuiz(@RequestBody QuizDTO quizDTO) {
        return quizService.criarQuiz(quizDTO);
    }
}

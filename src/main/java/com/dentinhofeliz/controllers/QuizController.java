package com.dentinhofeliz.controllers;

import com.dentinhofeliz.dto.QuizDTO;
import com.dentinhofeliz.entities.Quiz;
import com.dentinhofeliz.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @GetMapping
    public List<EntityModel<Quiz>> listarQuizzes() {
        return quizService.listarTodos().stream()
                .map(quiz -> EntityModel.of(quiz,
                        linkTo(methodOn(QuizController.class).listarQuiz(quiz.getId())).withSelfRel(),
                        linkTo(methodOn(QuizController.class).listarQuizzes()).withRel("quizzes")))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public EntityModel<Quiz> listarQuiz(@PathVariable Long id) {
        Quiz quiz = quizService.buscarPorId(id);
        return EntityModel.of(quiz,
                linkTo(methodOn(QuizController.class).listarQuiz(id)).withSelfRel(),
                linkTo(methodOn(QuizController.class).listarQuizzes()).withRel("quizzes"));
    }

    @PostMapping
    public EntityModel<Quiz> criarQuiz(@RequestBody QuizDTO quizDTO) {
        Quiz quiz = quizService.criarQuiz(quizDTO);
        return EntityModel.of(quiz,
                linkTo(methodOn(QuizController.class).listarQuiz(quiz.getId())).withSelfRel(),
                linkTo(methodOn(QuizController.class).listarQuizzes()).withRel("quizzes"));
    }
}

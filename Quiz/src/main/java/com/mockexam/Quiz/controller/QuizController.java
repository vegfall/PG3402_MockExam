package com.mockexam.Quiz.controller;

import com.mockexam.Quiz.dto.QuizDTO;
import com.mockexam.Quiz.service.SimpleQuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final SimpleQuizService simpleQuizService;

    public QuizController() {
        simpleQuizService = new SimpleQuizService();
    }

    @GetMapping("/{quizKey}")
    public ResponseEntity<QuizDTO> getQuiz(@PathVariable String quizKey) {
        QuizDTO foundQuizDTO = simpleQuizService.getQuiz(quizKey);

        return new ResponseEntity<>(foundQuizDTO, HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<QuizDTO> postQuiz() {
        QuizDTO createdQuizDTO = simpleQuizService.postQuiz();

        return new ResponseEntity<>(createdQuizDTO, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Quiz responding...");
    }
}

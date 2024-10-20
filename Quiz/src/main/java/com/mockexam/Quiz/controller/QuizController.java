package com.mockexam.Quiz.controller;

import com.mockexam.Quiz.dto.QuizDTO;
import com.mockexam.Quiz.service.SimpleQuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final SimpleQuizService quizService;

    public QuizController() {
        quizService = new SimpleQuizService();
    }

    @GetMapping("/{quizKey}")
    public ResponseEntity<QuizDTO> getQuiz(@PathVariable String quizKey) {
        QuizDTO foundQuizDTO = quizService.getQuiz(quizKey);

        return foundQuizDTO != null
                ? new ResponseEntity<>(foundQuizDTO, HttpStatus.FOUND)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<QuizDTO> postQuiz() {
        QuizDTO createdQuizDTO = quizService.postQuiz();

        return new ResponseEntity<>(createdQuizDTO, HttpStatus.CREATED);
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Quiz responding...");
    }
}

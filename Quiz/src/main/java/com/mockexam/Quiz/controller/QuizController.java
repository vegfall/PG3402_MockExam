package com.mockexam.Quiz.controller;

import com.mockexam.Quiz.client.QuestionClient;
import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.QuizDTO;
import com.mockexam.Quiz.service.SimpleQuizService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final SimpleQuizService quizService;
    private final QuestionClient questionClient;

    public QuizController() {
        quizService = new SimpleQuizService();
        questionClient = new QuestionClient(new RestTemplateBuilder());
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

    @GetMapping("/testQuestion")
    public ResponseEntity<String> testSyncCommunication() {
        return ResponseEntity.ok(questionClient.getTestResponse());
    }

    @GetMapping("/testNextQuestion")
    public ResponseEntity<QuestionDTO> testNextQuestion() {
        return ResponseEntity.ok(questionClient.getNextQuestion("1234", 1));
    }

    @GetMapping("/testAllQuestions")
    public ResponseEntity<List<QuestionDTO>> testGetAllQuestions() {
        return ResponseEntity.ok(questionClient.getAllQuestions("1234"));
    }
}

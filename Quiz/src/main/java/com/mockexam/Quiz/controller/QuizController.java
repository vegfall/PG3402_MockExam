package com.mockexam.Quiz.controller;

import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.ResultDTO;
import com.mockexam.Quiz.dto.SessionDTO;
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

    @GetMapping("{sessionKey}/current-question")
    public ResponseEntity<QuestionDTO> getCurrentQuestion(@PathVariable String sessionKey) {
        QuestionDTO question = quizService.getCurrentQuestion(sessionKey);

        return question != null
                ? new ResponseEntity<>(question, HttpStatus.FOUND)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Hardcoded for testing
    @PostMapping("new-quiz")
    public ResponseEntity<SessionDTO> newQuiz() {
        return new ResponseEntity<>(quizService.newQuiz("1234"), HttpStatus.CREATED);
    }

    @PostMapping("{sessionKey}/response/{alternativeKey}")
    public ResponseEntity<ResultDTO> postAnswer(@PathVariable String sessionKey, @PathVariable int alternativeKey) {
        ResultDTO result = quizService.postAnswer(sessionKey, alternativeKey);

        return result != null
                ? new ResponseEntity<>(result, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{sessionKey}/next-question")
    public ResponseEntity<String> nextQuestion(@PathVariable String sessionKey) {
        return quizService.nextQuestion(sessionKey)
                ? new ResponseEntity<>("New question...", HttpStatus.OK)
                : new ResponseEntity<>("Quiz done...", HttpStatus.NOT_FOUND);
    }
}

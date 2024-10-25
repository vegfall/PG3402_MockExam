package com.mockexam.Question.controller;

import com.mockexam.Question.dto.QuestionDTO;
import com.mockexam.Question.dto.ResultDTO;
import com.mockexam.Question.service.SimpleQuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    private final SimpleQuestionService questionService;

    public QuestionController() {
        questionService = new SimpleQuestionService();
    }

    @GetMapping("{sessionKey}/current-question")
    public ResponseEntity<QuestionDTO> getCurrentQuestion(@PathVariable String sessionKey) {
        return null;
    }

    @PostMapping("{sessionKey}/response/{alternativeKey}")
    public ResponseEntity<ResultDTO> postAnswer(@PathVariable String sessionKey, @PathVariable int alternativeKey) {
        return null;
    }

    /*




    @GetMapping("{quizKey}/{questionId}")
    public ResponseEntity<QuestionDTO> getNextQuestion(@PathVariable String quizKey, @PathVariable Integer questionId) {
        QuestionDTO question = questionService.getNextQuestion(quizKey, questionId);

        return question != null ? new ResponseEntity<>(question, HttpStatus.FOUND) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("{quizKey}")
    public ResponseEntity<List<QuestionDTO>> getAllQuestions(@PathVariable String quizKey) {
        List<QuestionDTO> questions = questionService.getAllQuestions(quizKey);

        return questions != null ? new ResponseEntity<>(questions, HttpStatus.FOUND) : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping("test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Question responding...");
    }

     */
}

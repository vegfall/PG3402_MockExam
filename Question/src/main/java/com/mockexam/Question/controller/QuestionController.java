package com.mockexam.Question.controller;

import com.mockexam.Question.dto.QuestionDTO;
import com.mockexam.Question.dto.AnswerResultDTO;
import com.mockexam.Question.service.SimpleQuestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/question")
public class QuestionController {
    private final SimpleQuestionService questionService;

    public QuestionController() {
        questionService = new SimpleQuestionService();
    }

    @GetMapping("{sessionKey}/current-question/{questionKey}")
    public ResponseEntity<QuestionDTO> getCurrentQuestion(@PathVariable String sessionKey, @PathVariable int questionKey) {
        QuestionDTO question = questionService.getCurrentQuestion(sessionKey, questionKey);

        return question != null
                ? new ResponseEntity<>(question, HttpStatus.FOUND)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("{sessionKey}/current-question-id/{questionKey}")
    public ResponseEntity<Long> getCurrentQuestionId(@PathVariable String sessionKey, @PathVariable int questionKey) {
        Long questionId = questionService.getCurrentQuestionId(sessionKey, questionKey);

        return new ResponseEntity<>(questionId, HttpStatus.FOUND);
    }

    @PostMapping("{sessionKey}/answer/{questionKey}/{alternativeKey}")
    public ResponseEntity<AnswerResultDTO> postAnswer(@PathVariable String sessionKey, @PathVariable int questionKey, @PathVariable int alternativeKey) {
        AnswerResultDTO answerResult = questionService.postAnswer(sessionKey, questionKey, alternativeKey);

        return answerResult != null
                ? new ResponseEntity<>(answerResult, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}

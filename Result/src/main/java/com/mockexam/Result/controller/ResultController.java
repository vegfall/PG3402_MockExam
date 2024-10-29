package com.mockexam.Result.controller;

import com.mockexam.Result.dto.AnswerResultDTO;
import com.mockexam.Result.dto.OverallResultDTO;
import com.mockexam.Result.dto.QuestionDTO;
import com.mockexam.Result.service.SimpleResultService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/result")
public class ResultController {
    private final SimpleResultService resultService;

    public ResultController() {
        resultService = new SimpleResultService();
    }

    @GetMapping("{sessionKey}/overall-result")
    public ResponseEntity<OverallResultDTO> getOverallResult(@PathVariable String sessionKey) {
        OverallResultDTO overallResult = resultService.getOverallResult(sessionKey);

        return overallResult != null
                ? new ResponseEntity<>(overallResult, HttpStatus.FOUND)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Should receive the QuestionDTO and the alternativeKey of the correct question.
    @PostMapping("{sessionKey}/answer/{guessedKey}/{correctKey}")
    public ResponseEntity<AnswerResultDTO> postAnswer(@PathVariable String sessionKey, @PathVariable int guessedKey, @PathVariable int correctKey, @RequestBody QuestionDTO question) {
        AnswerResultDTO answerResult = resultService.postAnswer(sessionKey, guessedKey, correctKey, question);

        return answerResult != null
                ? new ResponseEntity<>(answerResult, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

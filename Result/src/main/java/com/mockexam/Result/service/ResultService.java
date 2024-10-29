package com.mockexam.Result.service;

import com.mockexam.Result.dto.AnswerResultDTO;
import com.mockexam.Result.dto.OverallResultDTO;
import com.mockexam.Result.dto.QuestionDTO;

public interface ResultService {
    OverallResultDTO getOverallResult(String sessionKey);
    AnswerResultDTO postAnswer(String sessionKey, int guessedKey, int correctKey, QuestionDTO question);
}

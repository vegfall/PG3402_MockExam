package com.mockexam.Result.service;

import com.mockexam.Result.dto.AnswerResultDTO;
import com.mockexam.Result.dto.OverallResultDTO;
import com.mockexam.Result.dto.QuestionDTO;
import com.mockexam.Result.model.OverallResult;
import com.mockexam.Result.repository.MockResultRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleResultService implements ResultService {
    private final MockResultRepository resultRepository;

    public SimpleResultService() {
        resultRepository = new MockResultRepository();
    }

    @Override
    public OverallResultDTO getOverallResult(String sessionKey) {
        return null;
    }

    @Override
    public AnswerResultDTO postAnswer(String sessionKey, int guessedKey, int correctKey, QuestionDTO question) {
        OverallResult overallResult = resultRepository.getOverallResult(sessionKey);
        AnswerResultDTO answerResult;

        if (guessedKey == correctKey) {
            overallResult.setCorrectAnswers(overallResult.getCorrectAnswers() + 1);
            answerResult = new AnswerResultDTO(true);
        } else {
            answerResult = new AnswerResultDTO(false);
        }

        return answerResult;
    }
}

package com.mockexam.Result.model;

import com.mockexam.Result.dto.OverallResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class OverallResult {
    private final String sessionKey;
    private int totalQuestions;
    private int correctAnswers;
    private int score;

    public OverallResultDTO getDTO() {
        return new OverallResultDTO(sessionKey, totalQuestions, correctAnswers, score);
    }
}

package com.mockexam.Result.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class OverallResultDTO {
    private String sessionKey;
    private int totalQuestions;
    private int correctAnswers;
    private int score;
}

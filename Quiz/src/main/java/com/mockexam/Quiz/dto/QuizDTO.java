package com.mockexam.Quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class QuizDTO {
    private Long quizId;
    private String category;
    private int storedQuestions;
    LocalDateTime createdAt;
}

package com.mockexam.Quiz.model;

import com.mockexam.Quiz.dto.QuizDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class Quiz {
    private Long quizId;
    private String category;
    List<Long> questionIds;
    LocalDateTime createdAt;

    public QuizDTO getDTO() {
        return new QuizDTO(quizId, category, questionIds.size(), createdAt);
    }
}

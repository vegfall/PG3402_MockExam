package com.mockexam.Quiz.model;

import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.QuizDTO;
import com.mockexam.Quiz.misc.QuizStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Quiz {
    private Long quizId;
    private String quizKey;
    private int numberOfQuestions;
    private QuizStatus status;
    private List<QuestionDTO> questions;

    public QuizDTO getDTO() {
        return new QuizDTO(quizKey, status, questions);
    }
}

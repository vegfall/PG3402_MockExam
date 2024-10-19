package com.mockexam.Quiz.dto;

import com.mockexam.Quiz.misc.QuizStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class QuizDTO {
    private String quizKey;
    private QuizStatus status;
    private List<QuestionDTO> questions;
}

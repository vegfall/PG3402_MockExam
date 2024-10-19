package com.mockexam.Quiz.service;

import com.mockexam.Quiz.dto.QuizDTO;
import org.springframework.http.ResponseEntity;

public interface QuizService {
    QuizDTO getQuiz(String quizKey);
    QuizDTO postQuiz();
}

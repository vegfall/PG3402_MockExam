package com.mockexam.Question.service;

import com.mockexam.Question.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionDTO> getAllQuestions(String quizKey);
    QuestionDTO getNextQuestion(String quizKey, Integer questionId);
}

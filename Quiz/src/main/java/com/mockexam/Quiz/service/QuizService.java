package com.mockexam.Quiz.service;

import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.ResultDTO;

public interface QuizService {
    QuestionDTO getCurrentQuestion(String sessionKey);
    ResultDTO postAnswer(String sessionKey, int alternativeKey);
    boolean nextQuestion(String sessionKey);
}

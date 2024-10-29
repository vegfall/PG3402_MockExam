package com.mockexam.Quiz.service;

import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.AnswerResultDTO;
import com.mockexam.Quiz.dto.SessionDTO;

public interface QuizService {
    QuestionDTO getCurrentQuestion(String sessionKey);
    AnswerResultDTO postAnswer(String sessionKey, int alternativeKey);
    boolean nextQuestion(String sessionKey);

    SessionDTO newQuiz(String sessionKey);
}

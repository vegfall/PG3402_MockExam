package com.mockexam.Question.service;

import com.mockexam.Question.dto.AnswerResultDTO;
import com.mockexam.Question.dto.QuestionDTO;

public interface QuestionService {
    QuestionDTO getCurrentQuestion(String sessionKey, int questionKey);
    Long getCurrentQuestionId(String sessionKey, int questionKey);
    AnswerResultDTO postAnswer(String sessionKey, int questionKey, int alternativeKey);
}

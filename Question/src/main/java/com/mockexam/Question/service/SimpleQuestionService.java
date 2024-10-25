package com.mockexam.Question.service;

import com.mockexam.Question.dto.QuestionDTO;
import com.mockexam.Question.model.Question;
import com.mockexam.Question.repository.MockQuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class SimpleQuestionService implements QuestionService {
    private final MockQuestionRepository questionRepository;

    public SimpleQuestionService() {
        questionRepository = new MockQuestionRepository();
    }

    @Override
    public QuestionDTO getCurrentQuestion(String sessionKey, int questionKey) {
        return questionRepository.getNextQuestion(sessionKey, questionKey).getDTO();
    }

    @Override
    public Long getCurrentQuestionId(String sessionKey, int questionKey) {
        Question question = questionRepository.getNextQuestion(sessionKey, questionKey);

        return question != null
                ? question.getQuestionId()
                : null;
    }
}

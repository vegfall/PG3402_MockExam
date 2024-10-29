package com.mockexam.Question.service;

import com.mockexam.Question.client.ResultClient;
import com.mockexam.Question.dto.AnswerResultDTO;
import com.mockexam.Question.dto.QuestionDTO;
import com.mockexam.Question.model.Alternative;
import com.mockexam.Question.model.Question;
import com.mockexam.Question.repository.MockQuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimpleQuestionService implements QuestionService {
    private final MockQuestionRepository questionRepository;
    private final ResultClient resultClient;

    public SimpleQuestionService() {
        questionRepository = new MockQuestionRepository();
        resultClient = new ResultClient(new RestTemplateBuilder());
    }

    @Override
    public QuestionDTO getCurrentQuestion(String sessionKey, int questionKey) {
        return questionRepository.getQuestion(sessionKey, questionKey).getDTO();
    }

    @Override
    public Long getCurrentQuestionId(String sessionKey, int questionKey) {
        Question question = questionRepository.getQuestion(sessionKey, questionKey);

        return question != null
                ? question.getQuestionId()
                : null;
    }

    @Override
    public AnswerResultDTO postAnswer(String sessionKey, int questionKey, int alternativeKey) {
        Question currentQuestion = questionRepository.getQuestion(sessionKey, questionKey);
        int correctAlternativeKey = 0;

        for (Alternative alternative : currentQuestion.getAlternatives()) {
            if (alternative.isCorrect()) {
                correctAlternativeKey = alternative.getAlternativeKey();
                break;
            }
        }

        return resultClient.postAnswer(sessionKey, currentQuestion.getDTO(), alternativeKey, correctAlternativeKey);
    }
}

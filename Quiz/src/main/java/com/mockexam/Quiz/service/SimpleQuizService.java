package com.mockexam.Quiz.service;

import com.mockexam.Quiz.client.QuestionClient;
import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.ResultDTO;
import com.mockexam.Quiz.repository.MockQuizRepository;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

@Service
public class SimpleQuizService implements QuizService {
    private final MockQuizRepository mockQuizRepository;
    private final QuestionClient questionClient;

    public SimpleQuizService() {
        mockQuizRepository = new MockQuizRepository();
        questionClient = new QuestionClient(new RestTemplateBuilder());
    }

    @Override
    public QuestionDTO getCurrentQuestion(String sessionKey) {
        return null;
    }

    @Override
    public ResultDTO postAnswer(String sessionKey, int alternativeKey) {
        return null;
    }

    @Override
    public boolean nextQuestion(String sessionKey) {
        return false;
    }
}

package com.mockexam.Quiz.service;

import com.mockexam.Quiz.client.QuestionClient;
import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.ResultDTO;
import com.mockexam.Quiz.dto.SessionDTO;
import com.mockexam.Quiz.model.Session;
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
        Session session = mockQuizRepository.getSession(sessionKey);
        int currentQuestionIndex = session.getQuestionIds().size();

        return questionClient.getCurrentQuestion(sessionKey, currentQuestionIndex);
    }

    @Override
    public ResultDTO postAnswer(String sessionKey, int alternativeKey) {
        return questionClient.postAnswer(sessionKey, alternativeKey);
    }

    @Override
    public boolean nextQuestion(String sessionKey) {
        Session session = mockQuizRepository.getSession(sessionKey);
        Long nextQuestionId = questionClient.getCurrentQuestionId(sessionKey, session.getQuestionIds().size() + 1);

        if (nextQuestionId != null) {
            session.getQuestionIds().add(nextQuestionId);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public SessionDTO newQuiz(String sessionKey) {
        Session session = mockQuizRepository.getSession(sessionKey);
        Long firstQuestionId = questionClient.getCurrentQuestionId(sessionKey, 1);

        session.getQuestionIds().add(firstQuestionId);

        return mockQuizRepository.getSession(sessionKey).getDTO();
    }
}

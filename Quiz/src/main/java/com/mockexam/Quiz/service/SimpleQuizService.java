package com.mockexam.Quiz.service;

import com.mockexam.Quiz.dto.QuizDTO;
import com.mockexam.Quiz.repository.MockQuizRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SimpleQuizService implements QuizService {
    private final MockQuizRepository mockQuizRepository;

    public SimpleQuizService() {
        mockQuizRepository = new MockQuizRepository();
    }

    @Override
    public QuizDTO getQuiz(String quizKey) {
        return mockQuizRepository.getQuiz(quizKey).getDTO();
    }

    @Override
    public QuizDTO postQuiz() {
        return null;
    }
}

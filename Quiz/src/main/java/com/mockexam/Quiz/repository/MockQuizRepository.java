package com.mockexam.Quiz.repository;

import com.mockexam.Quiz.misc.QuizStatus;
import com.mockexam.Quiz.model.Quiz;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class MockQuizRepository {
    private final Dictionary<String, Quiz> mockQuizRepo;

    public MockQuizRepository() {
        mockQuizRepo = new Hashtable<>();

        CreateMockQuiz();
    }

    private void CreateMockQuiz() {
        Quiz quiz1234 = new Quiz(
            1L,
            "1234",
            2,
            QuizStatus.CREATED,
            new ArrayList<>()
        );

        mockQuizRepo.put("1234", quiz1234);
    }

    public Quiz getQuiz(String quizKey) {
        return mockQuizRepo.get(quizKey);
    }
}

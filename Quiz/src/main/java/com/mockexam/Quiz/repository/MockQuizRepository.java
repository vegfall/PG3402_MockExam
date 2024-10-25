package com.mockexam.Quiz.repository;

import com.mockexam.Quiz.misc.QuizStatus;
import com.mockexam.Quiz.model.Quiz;
import com.mockexam.Quiz.model.Session;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class MockQuizRepository {
    private final Dictionary<Long, Quiz> mockQuizRepo;
    private final Dictionary<String, Session> mockSessionRepo;

    public MockQuizRepository() {
        mockQuizRepo = new Hashtable<>();
        mockSessionRepo = new Hashtable<>();

        CreateMockQuiz();
        CreateMockSession();
    }

    private void CreateMockQuiz() {
        Quiz quiz1 = new Quiz(
            1L,
            "Capitals",
            new ArrayList<>(),
            LocalDateTime.now()
        );

        mockQuizRepo.put(1L, quiz1);
    }

    private void CreateMockSession() {
        Session session1234 = new Session(
                "1234",
                1L,
                3,
                mockQuizRepo.get(1L).getQuestionIds(),
                QuizStatus.CREATED,
                LocalDateTime.now()
        );

        mockSessionRepo.put("1234", session1234);
    }
}

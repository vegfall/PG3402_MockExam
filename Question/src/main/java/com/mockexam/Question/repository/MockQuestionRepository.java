package com.mockexam.Question.repository;

import com.mockexam.Question.model.Alternative;
import com.mockexam.Question.model.Question;

import java.util.*;

public class MockQuestionRepository {
    Dictionary<Integer, Question> mockQuestions;

    public MockQuestionRepository() {
        mockQuestions = new Hashtable<>();

        createMockQuestions();
    }

    private void createMockQuestions() {
        mockQuestions.put(1, new Question(
                1L,
                "What is the capital of Norway?",
                Arrays.asList(
                        new Alternative(1L, "Oslo", true),
                        new Alternative(2L, "Stockholm", false),
                        new Alternative(3L, "Copenhagen", false),
                        new Alternative(4L, "Reykjavik", false)
                ),
                1
        ));

        mockQuestions.put(2, new Question(
                2L,
                "What is the capital of Denmark?",
                Arrays.asList(
                        new Alternative(1L, "Oslo", false),
                        new Alternative(2L, "Stockholm", false),
                        new Alternative(3L, "Copenhagen", true),
                        new Alternative(4L, "Reykjavik", false)
                ),
                2
        ));

        mockQuestions.put(3, new Question(
                3L,
                "What is the capital of Iceland?",
                Arrays.asList(
                        new Alternative(1L, "Oslo", false),
                        new Alternative(2L, "Stockholm", false),
                        new Alternative(3L, "Copenhagen", false),
                        new Alternative(4L, "Reykjavik", true)
                ),
                3
        ));
    }

    public List<Question> getAllQuestions(String quizKey) {
        return Objects.equals(quizKey, "1234") ? Collections.list(mockQuestions.elements()).reversed() : null;
    }

    public Question getNextQuestion(String quizKey, Integer questionId) {
        return Objects.equals(quizKey, "1234") ? mockQuestions.get(questionId) : null;
    }
}

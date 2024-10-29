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
                1,
                "What is the capital of Norway?",
                Arrays.asList(
                        new Alternative(1L, 1, "Oslo", true),
                        new Alternative(2L, 2, "Stockholm", false),
                        new Alternative(3L, 3, "Copenhagen", false),
                        new Alternative(4L, 4, "Reykjavik", false)
                )
        ));

        mockQuestions.put(2, new Question(
                2L,
                2,
                "What is the capital of Denmark?",
                Arrays.asList(
                        new Alternative(5L, 1, "Oslo", false),
                        new Alternative(6L, 2, "Stockholm", false),
                        new Alternative(7L, 3, "Copenhagen", true),
                        new Alternative(8L, 4, "Reykjavik", false)
                )
        ));

        mockQuestions.put(3, new Question(
                3L,
                3,
                "What is the capital of Iceland?",
                Arrays.asList(
                        new Alternative(9L, 1, "Oslo", false),
                        new Alternative(10L, 2, "Stockholm", false),
                        new Alternative(11L, 3, "Copenhagen", false),
                        new Alternative(12L, 4, "Reykjavik", true)
                )
        ));
    }

    public Question getQuestion(String quizKey, Integer questionId) {
        return Objects.equals(quizKey, "1234") ? mockQuestions.get(questionId) : null;
    }
}

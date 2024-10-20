package com.mockexam.Question.service;

import com.mockexam.Question.dto.QuestionDTO;
import com.mockexam.Question.model.Question;
import com.mockexam.Question.repository.MockQuestionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SimpleQuestionService implements QuestionService {
    private final MockQuestionRepository questionRepository;

    public SimpleQuestionService() {
        questionRepository = new MockQuestionRepository();
    }

    @Override
    public List<QuestionDTO> getAllQuestions(String quizKey) {
        List<QuestionDTO> questionDTOs = new ArrayList<>();

        for(Question question : questionRepository.getAllQuestions(quizKey)) {
            questionDTOs.add(question.getDTO());
        }

        return questionDTOs;
    }

    @Override
    public QuestionDTO getNextQuestion(String quizKey, Integer questionId) {
        return questionRepository.getNextQuestion(quizKey, questionId).getDTO();
    }
}

package com.mockexam.Question.model;

import com.mockexam.Question.dto.AlternativeDTO;
import com.mockexam.Question.dto.QuestionDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Question {
    private Long questionId;
    private int questionKey;
    private String questionText;
    private List<Alternative> alternatives;

    public QuestionDTO getDTO() {
        List<AlternativeDTO> alternativeDTOs = new ArrayList<>();

        for (Alternative alt : alternatives) {
            alternativeDTOs.add(alt.getDTO());
        }

        return new QuestionDTO(questionKey, questionText, alternativeDTOs);
    }
}

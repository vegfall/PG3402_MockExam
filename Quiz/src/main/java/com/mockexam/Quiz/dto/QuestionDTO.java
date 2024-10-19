package com.mockexam.Quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class QuestionDTO {
    private Long questionId;
    private String questionText;
    private List<AlternativeDTO> alternatives;
    private int difficulty;
}

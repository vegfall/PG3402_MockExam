package com.mockexam.Quiz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AlternativeDTO {
    private Long alternativeId;
    private String alternativeText;
}

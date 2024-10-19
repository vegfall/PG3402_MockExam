package com.mockexam.Question.model;

import com.mockexam.Question.dto.AlternativeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Alternative {
    private Long alternativeId;
    private String alternativeText;
    private boolean correct;

    public AlternativeDTO getDTO() {
        return new AlternativeDTO(alternativeId, alternativeText);
    }
}

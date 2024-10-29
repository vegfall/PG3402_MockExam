package com.mockexam.Result.model;

import com.mockexam.Result.dto.AnswerResultDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AnswerResult {
    private String sessionKey;
    private boolean correct;

    public AnswerResultDTO getDTO() {
        return new AnswerResultDTO(correct);
    }
}

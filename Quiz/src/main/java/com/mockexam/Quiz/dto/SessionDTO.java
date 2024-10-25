package com.mockexam.Quiz.dto;

import com.mockexam.Quiz.misc.QuizStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class SessionDTO {
    private String sessionKey;
    private QuizStatus status;
    private LocalDateTime startedAt;
}

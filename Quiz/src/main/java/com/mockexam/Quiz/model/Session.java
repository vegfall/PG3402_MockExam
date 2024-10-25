package com.mockexam.Quiz.model;

import com.mockexam.Quiz.dto.SessionDTO;
import com.mockexam.Quiz.misc.QuizStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
public class Session {
    private String sessionKey;
    private Long quizId;
    private int maxQuestions;
    private List<Long> questionIds;
    private QuizStatus status;
    private LocalDateTime startedAt;

    public SessionDTO getDTO() {
        return new SessionDTO(sessionKey, status, startedAt);
    }
}

package com.mockexam.Question.client;

import com.mockexam.Question.dto.AnswerResultDTO;
import com.mockexam.Question.dto.QuestionDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class ResultClient {
    private final RestTemplate restTemplate;
    private final String resultUrl;

    public ResultClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        resultUrl = "http://127.0.0.1:8082/result/";
    }

    public AnswerResultDTO postAnswer(String sessionKey, QuestionDTO question, int guessedAlternativeKey, int correctAlternativeKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(resultUrl + sessionKey + "/answer/" + guessedAlternativeKey + "/" + correctAlternativeKey)
                .toUriString();

        try {
            HttpEntity<QuestionDTO> request = new HttpEntity<>(question);
            ResponseEntity<AnswerResultDTO> response = restTemplate.postForEntity(url, request,AnswerResultDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            log.error("Received error {} for url: {}", e, url);
            return null;
        }
    }
}

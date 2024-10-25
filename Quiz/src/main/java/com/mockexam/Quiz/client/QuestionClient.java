package com.mockexam.Quiz.client;

import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.ResultDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

//https://www.kapresoft.com/java/2023/10/16/spring-uricomponentsbuilder-best-practices.html
//https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate

@Slf4j
@Service
public class QuestionClient {
    private final RestTemplate restTemplate;
    private final String questionUrl;

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        questionUrl = "http://127.0.0.1:8081/question/";
    }

    public QuestionDTO getCurrentQuestion(String sessionKey, int questionKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + sessionKey + "/current-question/" + questionKey)
                .toUriString();

        ResponseEntity<QuestionDTO> response = restTemplate.getForEntity(url, QuestionDTO.class);

        return response.getBody();
    }

    public Long getCurrentQuestionId(String sessionKey, int questionKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + sessionKey + "/current-question-id/" + questionKey)
                .toUriString();

        ResponseEntity<Long> response = restTemplate.getForEntity(url, Long.class);

        return response.getBody();
    }

    public ResultDTO postAnswer(String sessionKey, int alternativeKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + sessionKey + "/response/" + alternativeKey)
                .toUriString();

        ResponseEntity<ResultDTO> response = restTemplate.getForEntity(url, ResultDTO.class);

        return response.getBody();
    }
}

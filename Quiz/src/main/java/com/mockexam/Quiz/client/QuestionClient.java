package com.mockexam.Quiz.client;

import com.mockexam.Quiz.dto.QuestionDTO;
import com.mockexam.Quiz.dto.ResultDTO;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

//https://www.kapresoft.com/java/2023/10/16/spring-uricomponentsbuilder-best-practices.html
//https://stackoverflow.com/questions/23674046/get-list-of-json-objects-with-spring-resttemplate

@Service
public class QuestionClient {
    private final RestTemplate restTemplate;
    private final String questionUrl;

    public QuestionClient(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
        questionUrl = "http://127.0.0.1:8081/question/";
    }

    public QuestionDTO getCurrentQuestion(String sessionKey, Integer questionKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + sessionKey + "/current-question")
                .toUriString();

        ResponseEntity<QuestionDTO> response = restTemplate.getForEntity(url, QuestionDTO.class);

        return response.getBody();
    }

    public ResultDTO postAnswer(String sessionKey, int alternativeKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + sessionKey + "/response/" + alternativeKey)
                .toUriString();

        ResponseEntity<ResultDTO> response = restTemplate.getForEntity(url, ResultDTO.class);

        return response.getBody();
    }

    /*
    public String getTestResponse() {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + "test")
                .toUriString();

        return restTemplate.getForObject(url, String.class);
    }

    public QuestionDTO getNextQuestion(String quizKey, Integer questionId) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + quizKey + "/" + questionId)
                .toUriString();

        ResponseEntity<QuestionDTO> response = restTemplate.getForEntity(url, QuestionDTO.class);

        return response.getBody();
    }

    public List<QuestionDTO> getAllQuestions(String quizKey) {
        String url = UriComponentsBuilder
                .fromHttpUrl(questionUrl + quizKey)
                .toUriString();

        //ResponseEntity<List<QuestionDTO>> response = restTemplate.getForEntity(url, List<QuestionDTO>.class);

        ResponseEntity<List<QuestionDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<QuestionDTO>>() {}
        );

        return response.getBody();
    }

     */
}

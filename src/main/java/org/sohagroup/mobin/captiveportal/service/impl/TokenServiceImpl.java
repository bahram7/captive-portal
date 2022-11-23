package org.sohagroup.mobin.captiveportal.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.config.Constants;
import org.sohagroup.mobin.captiveportal.service.Interface.TokenService;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.TokenModelRequest;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.TokenResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import reactor.core.publisher.Mono;

@Service
public class TokenServiceImpl implements TokenService {

    private final Logger logger = LogManager.getLogger(TokenServiceImpl.class);
    private final WebClient webClient;
    private final Gson gson;
    private final ObjectMapper objectMapper;

    public TokenServiceImpl(WebClient webClient, Gson gson) {
        this.webClient = webClient;
        this.gson = gson;
        this.objectMapper = new ObjectMapper();
    }

    @Value("mobin_esb")
    private String userName;

    @Value("G03TryPr5d3X^fk3")
    private String password;

    @Value("/api/token/")
    private String tokenUrl;

    @Value("${base-url}")
    private String baseUrl;

    //    @Value("${branches}")
    //    private String branchesUrl;

    @Override
    public Mono<ResponseEntity<TokenResponseDTO>> getToken(TokenModelRequest tokenModel) {
        try {
            return webClient
                .post()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(tokenUrl).build())
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.justOrEmpty(tokenModel), TokenModelRequest.class)
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> {
                    TokenResponseDTO tokenResponseDTO;
                    try {
                        tokenResponseDTO = objectMapper.readValue(str, TokenResponseDTO.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return ResponseEntity.status(HttpStatus.OK).body(tokenResponseDTO);
                })
                .doOnEach(logger::info)
                .doOnError(logger::error)
                .onErrorResume(error -> {
                    if (error instanceof WebClientResponseException) {
                        String message = ((WebClientResponseException) error).getResponseBodyAsString();
                        int statusCode = ((WebClientResponseException) error).getRawStatusCode();
                        throw Problem.builder().withDetail(message).withStatus(Status.valueOf(statusCode)).build();
                    }
                    return Mono.just(ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build());
                });
        } catch (Exception e) {
            logger.error("Exception in getToken : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }
}

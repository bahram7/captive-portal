package org.sohagroup.mobin.captiveportal.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.config.Constants;
import org.sohagroup.mobin.captiveportal.service.Interface.CategoriesService;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.CategoriesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import reactor.core.publisher.Mono;

@Service
public class CategoriesServiceImpl implements CategoriesService {

    private final Logger logger = LogManager.getLogger(CategoriesServiceImpl.class);
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final TokenRefresh tokenRefresh;

    public CategoriesServiceImpl(WebClient webClient, TokenRefresh tokenRefresh) {
        this.webClient = webClient;
        this.tokenRefresh = tokenRefresh;
        this.objectMapper = new ObjectMapper();
    }

    @Value("${base-url}")
    private String baseUrl;

    @Value("${categories}")
    private String categoriesUrl;

    @Override
    public Mono<CategoriesResponse> categoriesCreate(String appName, String token, Mono<CategoriesRequestModel> categoriesRequestModel) {
        logger.info("enter to createCategories in CategoriesServiceImpl with body : {}", categoriesRequestModel);

        try {
            return webClient
                .post()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(categoriesUrl).build())
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .contentType(MediaType.APPLICATION_JSON)
                .body(categoriesRequestModel, CategoriesRequestModel.class)
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> {
                    try {
                        return (objectMapper.readValue(body, CategoriesResponse.class));
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e.getMessage());
                    }
                })
                .doOnEach(logger::info)
                .doOnError(logger::error)
                .onErrorResume(error -> {
                    if (error instanceof WebClientResponseException) {
                        String message = ((WebClientResponseException) error).getResponseBodyAsString();
                        int statusCode = ((WebClientResponseException) error).getRawStatusCode();
                        throw Problem.builder().withDetail(message).withStatus(Status.valueOf(statusCode)).build();
                    }

                    return Mono.error(error);
                });
        } catch (Exception e) {
            logger.error("Exception in categoriesCreate : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<CategoriesResponse> getCategoriesById(String appName, String token, Integer id) {
        logger.info("enter to getCategoriesById in CategoriesServiceImpl with id : {}", id);

        try {
            return webClient
                .get()
                .uri(builder ->
                    builder
                        .scheme(Constants.HTTPS)
                        .host(baseUrl)
                        .path(categoriesUrl.concat("{id}/")) //concat(Constants.BRACES_ID))
                        .build(id)
                )
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> {
                    try {
                        return objectMapper.readValue(str, CategoriesResponse.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .doOnEach(logger::info)
                .doOnError(logger::error)
                .onErrorResume(error -> {
                    if (error instanceof WebClientResponseException) {
                        String message = ((WebClientResponseException) error).getResponseBodyAsString();
                        int statusCode = ((WebClientResponseException) error).getRawStatusCode();
                        throw Problem.builder().withDetail(message).withStatus(Status.valueOf(statusCode)).build();
                    }
                    return Mono.error(error);
                });
        } catch (Exception e) {
            logger.error("Exception in getCategoriesById : {}", e.getMessage(), e);
            if (e instanceof WebClientResponseException) throw Problem
                .builder()
                .withDetail(((WebClientResponseException) e).getResponseBodyAsString())
                .withStatus(Status.valueOf(((WebClientResponseException) e).getStatusCode().value()))
                .build();
            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<CategoriesListResponse> getAllCategories(String appName, String token) {
        logger.info("enter to getAllCategories in CategoriesServiceImpl");
        try {
            return webClient
                .get()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(categoriesUrl).build())
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> {
                    try {
                        return objectMapper.readValue(str, CategoriesListResponse.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                })
                .doOnEach(logger::info)
                .doOnError(logger::error)
                .onErrorResume(error -> {
                    if (error instanceof WebClientResponseException) {
                        String message = ((WebClientResponseException) error).getResponseBodyAsString();
                        int statusCode = ((WebClientResponseException) error).getRawStatusCode();
                        throw Problem.builder().withDetail(message).withStatus(Status.valueOf(statusCode)).build();
                    }
                    return Mono.error(error);
                });
        } catch (Exception e) {
            logger.error("Exception in getAllCategories", e.getMessage(), e);
            if (e instanceof WebClientResponseException) throw Problem
                .builder()
                .withDetail(((WebClientResponseException) e).getResponseBodyAsString())
                .withStatus(Status.valueOf(((WebClientResponseException) e).getStatusCode().value()))
                .build();
            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<HttpStatus> deleteCategoriesById(String appName, String token, Integer id) {
        logger.info("enter to CategoriesServiceImpl with id : {}", id);

        try {
            return webClient
                .delete()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(categoriesUrl.concat(Constants.BRACES_ID)).build(id))
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> HttpStatus.OK)
                .doOnEach(logger::info)
                .doOnError(logger::error)
                .onErrorResume(error -> {
                    if (error instanceof WebClientResponseException) {
                        String message = ((WebClientResponseException) error).getResponseBodyAsString();
                        int statusCode = ((WebClientResponseException) error).getRawStatusCode();
                        throw Problem.builder().withDetail(message).withStatus(Status.valueOf(statusCode)).build();
                    }
                    return Mono.error(error);
                });
        } catch (Exception e) {
            logger.error("Exception in deleteCategories : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }
}

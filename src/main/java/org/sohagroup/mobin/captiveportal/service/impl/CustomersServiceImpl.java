package org.sohagroup.mobin.captiveportal.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.config.Constants;
import org.sohagroup.mobin.captiveportal.service.Interface.CustomersService;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.CustomersRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import reactor.core.publisher.Mono;

@Service
public class CustomersServiceImpl implements CustomersService {

    private final Logger logger = LogManager.getLogger(CategoriesServiceImpl.class);
    private final WebClient webClient;
    private final ObjectMapper objectMapper;
    private final TokenRefresh tokenRefresh;

    public CustomersServiceImpl(WebClient webClient, ObjectMapper objectMapper, TokenRefresh tokenRefresh) {
        this.webClient = webClient;
        this.objectMapper = objectMapper;
        this.tokenRefresh = tokenRefresh;
    }

    @Value("${base-url}")
    private String baseUrl;

    @Value("${customers}")
    private String customersUrl;

    @Override
    public Mono<CustomersResponse> customersCreate(String appName, String token, Mono<CustomersRequestModel> customersRequestModel) {
        logger.info("enter to createCustomers in CustomersServiceImpl with body : {}", customersRequestModel);
        try {
            return webClient
                .post()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(customersUrl).build())
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .contentType(MediaType.APPLICATION_JSON)
                .body(customersRequestModel, CustomersRequestModel.class)
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> {
                    try {
                        return (objectMapper.readValue(body, CustomersResponse.class));
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
            logger.error("Exception in customersCreate : {}", e.getMessage());
            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<CustomersResponse> getCustomersById(String appName, String token, Integer id) {
        logger.info("enter to getCustomersById in CustomersServiceImpl with id : {}", id);
        try {
            return webClient
                .get()
                .uri(builder ->
                    builder
                        .scheme(Constants.HTTPS)
                        .host(baseUrl)
                        .path(customersUrl.concat("{id}/")) //concat(Constants.BRACES_ID))
                        .build(id)
                )
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> {
                    try {
                        return objectMapper.readValue(str, CustomersResponse.class);
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
            logger.error("Exception in getCustomersById : {}", e.getMessage(), e);
            if (e instanceof WebClientResponseException) throw Problem
                .builder()
                .withDetail(((WebClientResponseException) e).getResponseBodyAsString())
                .withStatus(Status.valueOf(((WebClientResponseException) e).getStatusCode().value()))
                .build();
            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<HttpStatus> deleteCustomersById(String appName, String token, Integer id) {
        logger.info("enter to CustomerServiceImpl with id : {}", id);
        try {
            return webClient
                .delete()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(customersUrl.concat(Constants.BRACES_ID)).build(id))
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
            logger.error("Exception in deleteCustomers : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<CustomersListResponse> getAllCustomers(String appName, String token) {
        logger.info("enter to getAllCustomers in CustomersServiceImpl");
        try {
            return webClient
                .get()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(customersUrl).build())
                .headers(h -> h.setBearerAuth(tokenRefresh.getAccessToken()))
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> {
                    try {
                        return objectMapper.readValue(str, CustomersListResponse.class);
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
            logger.error("Exception in getAllCustomers", e.getMessage(), e);
            if (e instanceof WebClientResponseException) throw Problem
                .builder()
                .withDetail(((WebClientResponseException) e).getResponseBodyAsString())
                .withStatus(Status.valueOf(((WebClientResponseException) e).getStatusCode().value()))
                .build();
            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }
}

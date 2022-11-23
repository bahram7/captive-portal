package org.sohagroup.mobin.captiveportal.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.config.Constants;
import org.sohagroup.mobin.captiveportal.service.Interface.BranchesService;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.BranchesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.support.WebExchangeBindException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import org.zalando.problem.Problem;
import org.zalando.problem.Status;
import reactor.core.publisher.Mono;

@Service
public class BranchesServiceImpl implements BranchesService {

    private final Logger logger = LogManager.getLogger(BranchesServiceImpl.class);
    private final WebClient webClient;
    private final Gson gson;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;

    public BranchesServiceImpl(WebClient webClient, RestTemplate restTemplate) {
        this.webClient = webClient;
        this.restTemplate = restTemplate;
        this.gson = new Gson();
        this.objectMapper = new ObjectMapper();
    }

    @Value("${base-url}")
    private String baseUrl;

    @Value("${branches}")
    private String branchesUrl;

    @Override
    public Mono<BranchesResponse> branchesCreate(String appName, String token, Mono<BranchesRequestModel> branchesRequestModel) {
        try {
            return webClient
                .post()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(branchesUrl).build())
                .headers(h ->
                    h.setBearerAuth(
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjY5MTkzMjAxLCJpYXQiOjE2NjkxOTI2MDEsImp0aSI6IjhhMzgyZWMzMTc5MjQ4NmNiZTZjOGNkNTA4OTVkNmEwIiwidXNlcl9pZCI6NiwiYWNjZXNzX3Rva2VuX2xpZmV0aW1lIjo2MDAsInVzZXJuYW1lIjoibW9iaW5fZXNiIn0.XIXe1aOQNRunZc50q844HKuT5fJagigEy5Gj5XeyjwA"
                    )
                )
                .contentType(MediaType.APPLICATION_JSON)
                .body(branchesRequestModel, BranchesRequestModel.class)
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> {
                    try {
                        return (objectMapper.readValue(str, BranchesResponse.class));
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

                    return Mono.empty();
                });
        } catch (Exception e) {
            logger.error("Exception in branchesCreate : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<ResponseEntity<BranchesListResponse>> getBranchesList(
        String appName,
        String token,
        String categoryCustomerCrmEnglishName,
        String categoryCustomerCrmId,
        Integer categoryCustomerId,
        String categoryCustomerName,
        String crmId,
        String crmName,
        Integer limit,
        Integer offset
    ) {
        logger.info("enter to getBranchesList in BranchesServiceImpl");
        try {
            return webClient
                .get()
                .uri(builder ->
                    builder
                        .scheme(Constants.HTTPS)
                        .host(baseUrl)
                        .path(branchesUrl)
                        .queryParamIfPresent(
                            Constants.CATEGORY_CUSTOMER_CRM_ENGLISH_NAME,
                            Optional.ofNullable(categoryCustomerCrmEnglishName)
                        )
                        .queryParamIfPresent(Constants.CATEGORY_CUSTOMER_CRM_ID, Optional.ofNullable(categoryCustomerCrmId))
                        .queryParamIfPresent(Constants.CATEGORY_CUSTOMER_ID, Optional.ofNullable(categoryCustomerId))
                        .queryParamIfPresent(Constants.CATEGORY_CUSTOMER_NAME, Optional.ofNullable(categoryCustomerName))
                        .queryParamIfPresent(Constants.CRM_ID_CONTAINS, Optional.ofNullable(crmId))
                        .queryParamIfPresent(Constants.CRM_NAME_CONTAINS, Optional.ofNullable(crmName))
                        .queryParamIfPresent(Constants.LIMIT, Optional.ofNullable(limit))
                        .queryParamIfPresent(Constants.OFFSET, Optional.ofNullable(offset))
                        .build()
                )
                .headers(h ->
                    h.setBearerAuth(
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjY5MTkzMjAxLCJpYXQiOjE2NjkxOTI2MDEsImp0aSI6IjhhMzgyZWMzMTc5MjQ4NmNiZTZjOGNkNTA4OTVkNmEwIiwidXNlcl9pZCI6NiwiYWNjZXNzX3Rva2VuX2xpZmV0aW1lIjo2MDAsInVzZXJuYW1lIjoibW9iaW5fZXNiIn0.XIXe1aOQNRunZc50q844HKuT5fJagigEy5Gj5XeyjwA"
                    )
                )
                .retrieve()
                .bodyToMono(String.class)
                .map(body -> {
                    BranchesListResponse branchesListResponse;
                    try {
                        branchesListResponse = objectMapper.readValue(body, BranchesListResponse.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }

                    return ResponseEntity.status(HttpStatus.OK).body(branchesListResponse);
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
            logger.error("Exception in getBranchesList : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<ResponseEntity<BranchesResponse>> getBranchesById(String appName, String token, Integer id) {
        logger.info("enter to getBranchesById in BranchesServiceImpl with id : {}", id);
        try {
            return webClient
                .get()
                .uri(builder ->
                    builder
                        .scheme(Constants.HTTPS)
                        .host(baseUrl)
                        .path(branchesUrl.concat("{id}/")) //concat(Constants.BRACES_ID))
                        .build(id)
                )
                .headers(h ->
                    h.setBearerAuth(
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjY5MTkzMjAxLCJpYXQiOjE2NjkxOTI2MDEsImp0aSI6IjhhMzgyZWMzMTc5MjQ4NmNiZTZjOGNkNTA4OTVkNmEwIiwidXNlcl9pZCI6NiwiYWNjZXNzX3Rva2VuX2xpZmV0aW1lIjo2MDAsInVzZXJuYW1lIjoibW9iaW5fZXNiIn0.XIXe1aOQNRunZc50q844HKuT5fJagigEy5Gj5XeyjwA"
                    )
                )
                .retrieve()
                .bodyToMono(String.class)
                //.map(str -> ResponseEntity.status(HttpStatus.OK).body(gson.fromJson(str, BranchesResponse.class)))

                .map(str -> {
                    BranchesResponse branchesResponse;
                    try {
                        branchesResponse = objectMapper.readValue(str, BranchesResponse.class);
                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }
                    return ResponseEntity.status(HttpStatus.OK).body(branchesResponse);
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
            //                .doOnEach(logger::info)
            //                .doOnError(logger::error)
            //                .onErrorResume(WebExchangeBindException.class,
            //                    ex -> Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).build()));

        } catch (Exception e) {
            logger.error("Exception in getBranchesById : {}", e.getMessage(), e);
            if (e instanceof WebClientResponseException) throw Problem
                .builder()
                .withDetail(((WebClientResponseException) e).getResponseBodyAsString())
                .withStatus(Status.valueOf(((WebClientResponseException) e).getStatusCode().value()))
                .build();
            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }

    @Override
    public Mono<ResponseEntity<Object>> deleteBranchesById(String appName, String token, Integer id) {
        logger.info("enter to apiBranchesDestroy in BranchesServiceImpl with id : {}", id);
        try {
            return webClient
                .delete()
                .uri(builder -> builder.scheme(Constants.HTTPS).host(baseUrl).path(branchesUrl.concat(Constants.BRACES_ID)).build(id))
                .headers(h ->
                    h.setBearerAuth(
                        "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjY5MTkzMjAxLCJpYXQiOjE2NjkxOTI2MDEsImp0aSI6IjhhMzgyZWMzMTc5MjQ4NmNiZTZjOGNkNTA4OTVkNmEwIiwidXNlcl9pZCI6NiwiYWNjZXNzX3Rva2VuX2xpZmV0aW1lIjo2MDAsInVzZXJuYW1lIjoibW9iaW5fZXNiIn0.XIXe1aOQNRunZc50q844HKuT5fJagigEy5Gj5XeyjwA"
                    )
                )
                .retrieve()
                .bodyToMono(String.class)
                .map(str -> ResponseEntity.status(HttpStatus.OK).build())
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
            logger.error("Exception in deleteBranches : {}", e.getMessage());

            throw Problem.builder().withStatus(Status.PRECONDITION_FAILED).build();
        }
    }
}

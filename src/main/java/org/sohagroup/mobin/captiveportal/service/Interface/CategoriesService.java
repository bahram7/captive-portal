package org.sohagroup.mobin.captiveportal.service.Interface;

import org.sohagroup.mobin.captiveportal.web.rest.model.request.CategoriesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public interface CategoriesService {
    Mono<CategoriesResponse> categoriesCreate(String appName, String token, Mono<CategoriesRequestModel> categoriesRequestModel);
    Mono<CategoriesResponse> getCategoriesById(String appName, String token, Integer id);
    Mono<HttpStatus> deleteCategoriesById(String appName, String token, Integer id);
    Mono<CategoriesListResponse> getAllCategories(String appName, String token);
}

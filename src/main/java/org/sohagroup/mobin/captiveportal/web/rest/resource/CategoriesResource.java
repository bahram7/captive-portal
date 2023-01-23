package org.sohagroup.mobin.captiveportal.web.rest.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.service.Interface.CategoriesService;
import org.sohagroup.mobin.captiveportal.web.rest.api.CategoriesApi;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.CategoriesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CategoriesResource implements CategoriesApi {

    private final Logger logger = LogManager.getLogger(CategoriesResource.class);

    private final CategoriesService categoriesService;

    public CategoriesResource(CategoriesService categoriesService) {
        this.categoriesService = categoriesService;
    }

    @Override
    public Mono<CategoriesResponse> categoriesCreate(String appName, String token, Mono<CategoriesRequestModel> categoriesRequestModel) {
        return categoriesService.categoriesCreate(appName, token, categoriesRequestModel);
    }

    @Override
    public Mono<CategoriesResponse> getCategoriesById(String appName, String token, Integer id) {
        return categoriesService.getCategoriesById(appName, token, id);
    }

    public Mono<CategoriesListResponse> getAllCategories(String appName, String token) {
        return categoriesService.getAllCategories(appName, token);
    }

    @Override
    public Mono<HttpStatus> deleteCategoriesById(String appName, String token, Integer id) {
        return categoriesService.deleteCategoriesById(appName, token, id);
    }
}

package org.sohagroup.mobin.captiveportal.web.rest.api;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.CategoriesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CategoriesResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Api
public interface CategoriesApi {
    @ApiOperation(value = "CategoriesCreate")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CategoriesResponse.class) })
    @PostMapping(value = "/api/categories")
    Mono<CategoriesResponse> categoriesCreate(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token") String token,
        @RequestBody Mono<CategoriesRequestModel> categoriesRequestModel
    );

    @ApiOperation(value = "getCategoriesById")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CategoriesResponse.class) })
    @GetMapping(value = "/api/categories/{id}")
    Mono<CategoriesResponse> getCategoriesById(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String appName,
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String token,
        @Parameter(name = "id", description = "A unique integer value identifying this categories.", required = true) @PathVariable(
            "id"
        ) Integer id
    );

    @ApiOperation(value = "getAllCategories")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CategoriesResponse.class) })
    @GetMapping(value = "/api/categories")
    Mono<CategoriesListResponse> getAllCategories(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String appName,
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String token
    );

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/categories/{id}/", produces = { "application/json" })
    Mono<HttpStatus> deleteCategoriesById(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName", required = true) String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token", required = true) String token,
        @Parameter(name = "id", description = "A unique integer value identifying this categories.", required = true) @PathVariable(
            "id"
        ) Integer id
    );
}

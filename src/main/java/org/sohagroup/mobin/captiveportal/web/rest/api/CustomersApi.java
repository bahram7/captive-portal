package org.sohagroup.mobin.captiveportal.web.rest.api;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.CustomersRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Api
public interface CustomersApi {
    @ApiOperation(value = "CustomersCreate")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CustomersResponse.class) })
    @PostMapping(value = "/api/customers")
    Mono<CustomersResponse> CustomersCreate(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token") String token,
        @RequestBody Mono<CustomersRequestModel> customersRequestModel
    );

    @ApiOperation(value = "getCustomersById")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CustomersResponse.class) })
    @GetMapping(value = "/api/customers/{id}")
    Mono<CustomersResponse> getCustomersById(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String appName,
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String token,
        @Parameter(name = "id", description = "A unique integer value identifying this Customers.", required = true) @PathVariable(
            "id"
        ) Integer id
    );

    @ApiOperation(value = "getAllCustomers")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = CustomersResponse.class) })
    @GetMapping(value = "/api/customers")
    Mono<CustomersListResponse> getAllCustomers(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String appName,
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName") String token
    );

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/customer/{id}/", produces = { "application/json" })
    Mono<HttpStatus> deleteCustomersById(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName", required = true) String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token", required = true) String token,
        @Parameter(name = "id", description = "A unique integer value identifying this customer.", required = true) @PathVariable(
            "id"
        ) Integer id
    );
}

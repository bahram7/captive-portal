package org.sohagroup.mobin.captiveportal.service.Interface;

import org.sohagroup.mobin.captiveportal.web.rest.model.request.CustomersRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

//@Component
public interface CustomersService {
    Mono<CustomersResponse> customersCreate(String appName, String token, Mono<CustomersRequestModel> customersRequestModel);
    Mono<CustomersResponse> getCustomersById(String appName, String token, Integer id);
    Mono<CustomersListResponse> getAllCustomers(String appName, String token);
    Mono<HttpStatus> deleteCustomersById(String appName, String token, Integer id);
}

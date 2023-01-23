package org.sohagroup.mobin.captiveportal.web.rest.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.service.Interface.CustomersService;
import org.sohagroup.mobin.captiveportal.web.rest.api.CustomersApi;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.CustomersRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.CustomersResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CustomersResource implements CustomersApi {

    private final Logger logger = LogManager.getLogger(CustomersResource.class);
    private final CustomersService customersService;

    public CustomersResource(CustomersService customersService) {
        this.customersService = customersService;
    }

    @Override
    public Mono<CustomersResponse> CustomersCreate(String appName, String token, Mono<CustomersRequestModel> customersRequestModel) {
        logger.info("customerRequestModel details receive in customerResource with body: {}", customersRequestModel);
        return customersService.customersCreate(appName, token, customersRequestModel);
    }

    @Override
    public Mono<CustomersResponse> getCustomersById(String appName, String token, Integer id) {
        logger.info("getCustomerById details receive in customerResource with id: {}", id);
        return customersService.getCustomersById(appName, token, id);
    }

    @Override
    public Mono<CustomersListResponse> getAllCustomers(String appName, String token) {
        logger.info("getAllCustomer receive in customerResource ");
        return customersService.getAllCustomers(appName, token);
    }

    @Override
    public Mono<HttpStatus> deleteCustomersById(String appName, String token, Integer id) {
        logger.info("deleteCustomerById details receive in customerResource with id: {}", id);
        return customersService.deleteCustomersById(appName, token, id);
    }
}

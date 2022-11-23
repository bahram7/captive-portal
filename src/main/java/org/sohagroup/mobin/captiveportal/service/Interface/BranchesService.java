package org.sohagroup.mobin.captiveportal.service.Interface;

import org.sohagroup.mobin.captiveportal.web.rest.model.request.BranchesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesResponse;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface BranchesService {
    Mono<ResponseEntity<BranchesListResponse>> getBranchesList(
        String AppName,
        String Token,
        String categoryCustomerCrmEnglishName,
        String categoryCustomerCrmId,
        Integer categoryCustomerId,
        String categoryCustomerName,
        String crmId,
        String crmName,
        Integer limit,
        Integer offset
    );

    Mono<ResponseEntity<BranchesResponse>> getBranchesById(String appName, String token, Integer id);

    Mono<ResponseEntity<Object>> deleteBranchesById(String appName, String token, Integer id);

    Mono<BranchesResponse> branchesCreate(String appName, String token, Mono<BranchesRequestModel> branchesRequestModel);
    //Mono<BranchesResponse> updateBranchesById(String appName, String token, Mono<BranchesRequestModel> branchesRequestModel,Integer id);
}

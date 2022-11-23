package org.sohagroup.mobin.captiveportal.web.rest.resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sohagroup.mobin.captiveportal.service.Interface.BranchesService;
import org.sohagroup.mobin.captiveportal.web.rest.api.BranchesApi;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.BranchesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BranchesResource implements BranchesApi {

    private final Logger logger = LogManager.getLogger(BranchesResource.class);

    private final BranchesService branchesService;

    public BranchesResource(BranchesService branchesService) {
        this.branchesService = branchesService;
    }

    @Override
    public Mono<BranchesResponse> branchesCreate(String appName, String token, Mono<BranchesRequestModel> branchesRequestModel) {
        return branchesService.branchesCreate(appName, token, branchesRequestModel);
    }

    @Override
    public Mono<ResponseEntity<BranchesListResponse>> getBranchesList(
        String appName,
        String token,
        String categorycustomerCrmEnglishName,
        String categoryCustomerCrmId,
        Integer categoryCustomerId,
        String categoryCustomerName,
        String crmId,
        String crmName,
        Integer limit,
        Integer offse
    ) {
        return branchesService.getBranchesList(
            appName,
            token,
            categorycustomerCrmEnglishName,
            categoryCustomerCrmId,
            categoryCustomerId,
            categoryCustomerName,
            crmId,
            crmName,
            limit,
            offse
        );
    }

    @Override
    public Mono<ResponseEntity<BranchesResponse>> getBranchesById(String appName, String token, Integer id) {
        return branchesService.getBranchesById(appName, token, id);
    }

    @Override
    public Mono<ResponseEntity<Object>> deleteBranchesById(String appName, String token, Integer id) {
        return branchesService.deleteBranchesById(appName, token, id);
    }
    //    @Override
    //    public Mono<BranchesResponse> updateBranchesById(String appName, String token, Mono<BranchesRequestModel> branchesRequestModel, Integer id) {
    //        return branchesService.updateBranchesById(appName,token,branchesRequestModel,id);
    //    }

}

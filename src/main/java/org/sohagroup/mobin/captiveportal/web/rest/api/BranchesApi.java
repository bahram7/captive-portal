package org.sohagroup.mobin.captiveportal.web.rest.api;

import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.Parameter;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.BranchesRequestModel;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesListResponse;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.BranchesResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@Api
public interface BranchesApi {
    @ApiOperation(value = "BranchesCreate")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = BranchesResponse.class) })
    @PostMapping(value = "/api/branches")
    public Mono<BranchesResponse> branchesCreate(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName", required = true) String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token", required = true) String token,
        @RequestBody Mono<BranchesRequestModel> branchesRequestModel
    );

    @ApiOperation(value = "BranchesList")
    @GetMapping(value = "/api/branches")
    public Mono<ResponseEntity<BranchesListResponse>> getBranchesList(
        @ApiParam(value = "appName", required = true) @RequestHeader(value = "appName", required = true) String appName,
        @ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
        @Parameter(name = "categorycustomercrm_english_name__contains", required = false) @RequestParam(
            value = "categorycustomercrm_english_name__contains",
            required = false
        ) String categorycustomercrm_english_name__contains,
        @Parameter(name = "categorycustomercrm_id", required = false) @RequestParam(
            value = "categorycustomercrm_id",
            required = false
        ) String categorycustomercrm_id,
        @Parameter(name = "categorycustomerid", required = false) @RequestParam(
            value = "categorycustomerid",
            required = false
        ) Integer categorycustomerid,
        @Parameter(name = "categorycustomername__contains", required = false) @RequestParam(
            value = "categorycustomername__contains",
            required = false
        ) String categorycustomername__contains,
        @Parameter(name = "crm_id__contains", required = false) @RequestParam(
            value = "crm_id__contains",
            required = false
        ) String crm_id__contains,
        @Parameter(name = "crm_name__contains", required = false) @RequestParam(
            value = "crm_name__contains",
            required = false
        ) String crm_name__contains,
        @Parameter(name = "limit", required = false) @RequestParam(value = "limit", required = false) Integer limit,
        @Parameter(name = "offset", required = false) @RequestParam(value = "offset", required = false) Integer offse
    );

    @RequestMapping(method = RequestMethod.GET, value = "/api/branches/{id}/", produces = { "application/json" })
    public Mono<ResponseEntity<BranchesResponse>> getBranchesById(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName", required = true) String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token", required = true) String token,
        @Parameter(name = "id", description = "A unique integer value identifying this branch.", required = true) @PathVariable(
            "id"
        ) Integer id
    );

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/branches/{id}/", produces = { "application/json" })
    public Mono<ResponseEntity<Object>> deleteBranchesById(
        @ApiParam(value = "AppName", required = true) @RequestHeader(value = "AppName", required = true) String appName,
        @ApiParam(value = "Token", required = true) @RequestHeader(value = "Token", required = true) String token,
        @Parameter(name = "id", description = "A unique integer value identifying this branch.", required = true) @PathVariable(
            "id"
        ) Integer id
    );
    //
    //    @ApiOperation(value = "UpdateBranches")
    //    @ApiResponses(value = {@ApiResponse(code = 200, message = "Success", response = BranchesResponse.class)})
    //    @PutMapping (value = "/api/branches")
    //    public Mono<BranchesResponse> updateBranchesById(
    //        @ApiParam(value = "AppName", required = true)
    //        @RequestHeader(value = "AppName", required = true) String appName,
    //        @ApiParam(value = "Token", required = true)
    //        @RequestHeader(value = "Token", required = true) String token,
    //        @RequestBody Mono<BranchesRequestModel> branchesRequestModel,
    //        @Parameter(name = "id", description = "A unique integer value identifying this branch.", required = true) @PathVariable("id") Integer id);

}

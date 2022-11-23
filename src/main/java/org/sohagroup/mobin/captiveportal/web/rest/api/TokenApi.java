package org.sohagroup.mobin.captiveportal.web.rest.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.sohagroup.mobin.captiveportal.web.rest.model.request.TokenModelRequest;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.TokenResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Api
@Validated
@RestController
public interface TokenApi {
    @ApiOperation(value = "Token")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Success", response = TokenResponseDTO.class) })
    @PostMapping(value = "/api/token")
    Mono<ResponseEntity<TokenResponseDTO>> getToken(TokenModelRequest tokenModel);
}

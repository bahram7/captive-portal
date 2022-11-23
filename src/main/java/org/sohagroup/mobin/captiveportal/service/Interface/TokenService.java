package org.sohagroup.mobin.captiveportal.service.Interface;

import org.sohagroup.mobin.captiveportal.web.rest.model.request.TokenModelRequest;
import org.sohagroup.mobin.captiveportal.web.rest.model.response.TokenResponseDTO;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface TokenService {
    Mono<ResponseEntity<TokenResponseDTO>> getToken(TokenModelRequest tokenModel);
}

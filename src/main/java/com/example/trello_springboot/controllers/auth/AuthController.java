package com.example.trello_springboot.controllers.auth;

import com.example.trello_springboot.controllers.ApiController;
import com.example.trello_springboot.dtos.auth.request.AccessTokenRequest;
import com.example.trello_springboot.dtos.auth.request.RefreshTokenRequest;
import com.example.trello_springboot.dtos.auth.response.TokenResponse;
import com.example.trello_springboot.services.auth.AuthService;
import org.springframework.boot.actuate.autoconfigure.metrics.export.dynatrace.DynatraceProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author "Tojaliyev Asliddin"
 * @since 10/09/22 10:46 (Saturday)
 * Trello_Spring-boot/IntelliJ IDEA
 */
@RestController
public class AuthController extends ApiController<AuthService> {
    public AuthController(AuthService service) {
        super(service);
    }

    @PostMapping(value = API+ V1+"/auth/access/token")
    public ResponseEntity<TokenResponse> register(@RequestBody AccessTokenRequest request){
        return new ResponseEntity<>(service.generateToken(request), HttpStatus.CREATED);
    }
    @PostMapping(value = API+ V1+"/auth/refresh/token")
    public ResponseEntity<TokenResponse> register(@RequestBody RefreshTokenRequest request){
        return new ResponseEntity<>(service.refreshToken(request),HttpStatus.CREATED);
    }
}

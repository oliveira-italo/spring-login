package com.example.login.controller.resource;

import com.example.login.controller.dto.TokenDTO;
import com.example.login.controller.dto.UserLoginDTO;
import com.example.login.controller.form.LoginForm;
import com.example.login.controller.service.TokenService;
import com.example.login.domain.interactor.LoginInteractor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private LoginInteractor loginInteractor;

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginForm form) {

        try {
            var authenticatedUser = (UserLoginDTO) manager.authenticate(new UsernamePasswordAuthenticationToken(form.email(), form.password())).getPrincipal();
            String jwt = tokenService.create(authenticatedUser);

            loginInteractor.saveSuccess(form.email());

            return ResponseEntity.ok(new TokenDTO(jwt));
        } catch (AuthenticationException exception) {
            loginInteractor.saveFail(form.email());
            throw exception;
        }
    }

}

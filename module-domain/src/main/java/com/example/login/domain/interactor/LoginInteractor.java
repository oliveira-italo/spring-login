package com.example.login.domain.interactor;

import com.example.login.domain.entity.Login;
import com.example.login.domain.gateway.LoginGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LoginInteractor {

    @Autowired
    private LoginGateway gateway;

    public void saveSuccess(String username) {
        saveLogin(new Login(username, LocalDateTime.now(), true));
    }

    public void saveFail(String username) {
        saveLogin(new Login(username, LocalDateTime.now(), false));
    }

    private void saveLogin(Login login) {
        gateway.save(login);
    }
}

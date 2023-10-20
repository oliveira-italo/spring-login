package com.example.login.controller;

import com.example.login.entities.User;
import com.example.login.usecase.interactor.UserInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInteractor interactor;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> create() {
        User user = interactor.create(new User("Foo", "foo@bar.email", "password"));
        return ResponseEntity.ok().build();
    }

}

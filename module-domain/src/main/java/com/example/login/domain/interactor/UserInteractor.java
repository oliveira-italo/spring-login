package com.example.login.domain.interactor;

import com.example.login.domain.entity.Role;
import com.example.login.domain.entity.User;
import com.example.login.domain.exception.UserNotFoundException;
import com.example.login.domain.gateway.UserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInteractor {

    @Autowired
    private UserGateway gateway;

    public User create(User user) {
        return gateway.create(user);
    }

    public User update(User user) {
        return gateway.update(user).orElseThrow(() -> new UserNotFoundException(user.getUuid()));
    }

    public User read(String uuid) {
        return gateway.read(uuid).orElseThrow(() -> new UserNotFoundException(uuid));
    }

    public void delete(String uuid) {
        Long deletedRecords = gateway.delete(uuid);
        if (deletedRecords.compareTo(1L) != 0L) {
            throw new UserNotFoundException(uuid);
        }
    }

    public User readByEmail(String email) {
        return gateway.readByEmail(email).orElseThrow(() -> new UserNotFoundException(email));
    }
}

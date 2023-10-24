package com.example.login.controller.service;

import com.example.login.controller.mapper.UserDTOMapper;
import com.example.login.domain.exception.UserNotFoundException;
import com.example.login.domain.interactor.UserInteractor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserInteractor userInteractor;

    @Autowired
    private UserDTOMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return mapper.toLoginDTO(userInteractor.readByEmail(username));
        } catch (UserNotFoundException ex) {
            throw new UsernameNotFoundException(ex.getMessage());
        }
    }
}

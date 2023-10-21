package com.example.login.controller.resource;

import com.example.login.controller.dto.UserDTO;
import com.example.login.controller.form.UserForm;
import com.example.login.controller.mapper.UserDTOMapper;
import com.example.login.domain.interactor.UserInteractor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserInteractor interactor;

    @Autowired
    private UserDTOMapper mapper;

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> create(@Valid @RequestBody UserForm form) {
        return ResponseEntity.ok(mapper.toDto(interactor.create(mapper.toDomain(form))));
    }

    @RequestMapping(method = GET, path = "/{uuid}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> read(@PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(mapper.toDto(interactor.read(uuid)));
    }

    @RequestMapping(method = PUT, path = "/{uuid}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> update(@Valid @RequestBody UserForm form, @PathVariable("uuid") String uuid) {
        return ResponseEntity.ok(mapper.toDto(interactor.update(mapper.toDomain(form, uuid))));
    }

    @RequestMapping(method = DELETE, path = "/{uuid}")
    public ResponseEntity<Void> delete(@PathVariable("uuid") String uuid) {
        interactor.delete(uuid);
        return ResponseEntity.ok().build();
    }
}

package com.mytelecom.controller;

import com.mytelecom.repository.entity.MyTelecomUser;
import static java.lang.String.format;
import com.mytelecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user-registration")
    public ResponseEntity<String> registration(@RequestBody @Valid MyTelecomUser myTelecomUser) {
    	MyTelecomUser savedUser = userService.registerUser(myTelecomUser);
        return new ResponseEntity<String>(format("User %s created successfully", savedUser.getId()), HttpStatus.CREATED);
    }

    @GetMapping("/users/{id}")
    public MyTelecomUser getDetails(@PathVariable String id){
        return userService.getDetails(id);
    }
}

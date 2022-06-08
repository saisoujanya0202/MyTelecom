package com.mytelecom.controller;

import com.mytelecom.repository.entity.MyTelecomUser;
import com.mytelecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user-registration")
    public void registration(@RequestBody @Valid MyTelecomUser myTelecomUser) {
        userService.registerUser(myTelecomUser);
    }

    @GetMapping("/users/{id}")
    public MyTelecomUser getDetails(@PathVariable String id){
        return userService.getDetails(id);
    }
}

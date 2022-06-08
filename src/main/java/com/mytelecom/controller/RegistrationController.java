package com.mytelecom.controller;

import com.mytelecom.repository.entity.MyTelecomUser;
import com.mytelecom.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/user-registration")
    public void registration(@RequestBody @Valid MyTelecomUser myTelecomUser) {
        registrationService.registerUser(myTelecomUser);
    }
}

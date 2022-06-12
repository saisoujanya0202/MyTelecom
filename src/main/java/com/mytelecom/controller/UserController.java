package com.mytelecom.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mytelecom.repository.entity.MyTelecomUser;
import com.mytelecom.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public MyTelecomUser getDetails(@PathVariable String id, Principal principal){
    	if(id!=null && id.equalsIgnoreCase(principal.getName()))
        	return userService.getDetails(id);
        else
        	throw new RuntimeException("You are not authorized to view this data");
    }
}

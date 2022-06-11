package com.mytelecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytelecom.repository.UserRepository;
import com.mytelecom.repository.entity.MyTelecomUser;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public MyTelecomUser getDetails(String id) {
        return userRepository.findById(id).get();
    }
}

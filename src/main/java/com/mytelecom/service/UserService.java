package com.mytelecom.service;

import com.mytelecom.repository.UserRepository;
import com.mytelecom.repository.entity.MyTelecomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(MyTelecomUser myTelecomUser) {
        Optional<MyTelecomUser> user = userRepository.findById(myTelecomUser.getId());
        if(user.isPresent()){
            throw new RuntimeException("User Id already exists!");
        }
        userRepository.save(myTelecomUser);
    }

    public MyTelecomUser getDetails(String id) {
        return userRepository.findById(id).get();
    }
}

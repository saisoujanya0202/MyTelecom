package com.mytelecom.service;

import com.mytelecom.repository.RegistrationRepository;
import com.mytelecom.repository.entity.MyTelecomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    public void registerUser(MyTelecomUser myTelecomUser) {
        registrationRepository.save(myTelecomUser);
    }
}

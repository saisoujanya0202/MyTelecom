package com.telecom.service;

import com.mytelecom.repository.UserRepository;
import com.mytelecom.repository.entity.MyTelecomUser;
import com.mytelecom.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.testng.AssertJUnit.assertEquals;

public class UserServiceTest {


    @Test
    void shouldThrowRuntimeExceptionIfUserExists(){

        String id = "saisoujanya0202@gmail.com";
        UserRepository repo = Mockito.mock(UserRepository.class);
        Optional<MyTelecomUser> optionalUserPost = getSampleUser(id);
        Mockito.when(repo.findById(id)).thenReturn(optionalUserPost);
        UserService service = new UserService(repo);
        Assertions.assertThrows(RuntimeException.class, ()->service.registerUser(optionalUserPost.get()));
    }

    @Test
    void shouldPostUserDetails(){

        String id = "saisoujanya0202@gmail.com";
        UserRepository repo = Mockito.mock(UserRepository.class);
        Optional.empty();
        Mockito.when(repo.findById(id)).thenReturn(Optional.empty());
        UserService service = new UserService(repo);
        MyTelecomUser user = new MyTelecomUser();
        user.setId(id);
        user.setBillingAddress("London");
        user.setName("Soujanya");
        user.setDateOfBirth(LocalDate.of(1997,11,21));
        user.setPhoneNumber("7000000000");
        user.setPassword("12345678");

        Mockito.when(repo.save(user)).thenReturn(user);

        MyTelecomUser returnedUser = service.registerUser(user);
        assertEquals(user.getId(),returnedUser.getId());


    }



    @Test
    void shouldGetDetailsById(){
        String id = "saisoujanya0202@gmail.com";
        UserRepository repo = Mockito.mock(UserRepository.class);
        Optional<MyTelecomUser> optionalUser = getSampleUser(id);
        Mockito.when(repo.findById(id)).thenReturn(optionalUser);
        UserService service = new UserService(repo);
        MyTelecomUser details = service.getDetails(id);

        assertEquals("London", details.getBillingAddress());
    }

    private Optional<MyTelecomUser> getSampleUser(String id) {
        MyTelecomUser user = new MyTelecomUser();
        user.setId(id);
        user.setBillingAddress("London");
        user.setName("Soujanya");
        user.setDateOfBirth(LocalDate.of(1997,11,21));
        user.setPhoneNumber("7000000000");
        user.setPassword("12345678");
        return Optional.of(user);
    }
}

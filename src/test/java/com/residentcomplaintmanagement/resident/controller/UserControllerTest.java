package com.residentcomplaintmanagement.resident.controller;

import com.residentcomplaintmanagement.resident.model.User;
import com.residentcomplaintmanagement.resident.respository.UserRepository;
import org.junit.After;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import java.util.List;
import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserControllerTest {

    @Autowired
    UserController userController;

    @Autowired
    UserRepository userRepository;

    @BeforeEach
    void setUp() {
    }



    @Test
   public void updateUsers() throws Exception{
//        final TestRestTemplate template = new TestRestTemplate();
        ResponseEntity<?> response = userController.createUsers(User.builder()
                .active(1).name("Karen").password("pass")
                .build());
        System.out.println(response.getBody());
        Assertions.assertTrue(() -> response.getStatusCode().is2xxSuccessful());
        System.out.println("First test successful");

        if (response.hasBody()){
            User body = (User)response.getBody();
            Assert.notNull(body, "Body must never be null");
            long id = body.getId();

            ResponseEntity<?> responseEntity = userController.UpdateUsers(body.toBuilder()
                    .name("Karen Duncan")
                    .build(), id);

            Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        }

//        List<User> all = userRepository.findAll();
//        System.out.println(all);

    }

    @After
    public void findAll(){

    }
}
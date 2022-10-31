package com.residentcomplaintmanagement.resident.controller;

import com.residentcomplaintmanagement.resident.model.User;
import com.residentcomplaintmanagement.resident.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/users")
    public ResponseEntity<?> getUsers(){
        try {
            List<User> users=userService.getUsers();
            return new ResponseEntity(users, HttpStatus.OK);


        } catch (Exception e){
            log.error("Error Occurred",e);
            return new ResponseEntity("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

@RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<?> createUsers(@RequestBody  User user ){
        try {
            log.info("User creation request created ");
            User userResponse=userService.createUser(user);
            if (userResponse!=null) {
                return new ResponseEntity(userResponse, HttpStatus.CREATED );
            }else {
                return new ResponseEntity("Error Occurred", HttpStatus.OK );
            }


        } catch (Exception e){
            log.error("Error Occurred",e);
            return new ResponseEntity("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "user/{user}",method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateUsers(@RequestBody  User user){
        try {
            log.info("User update request");
            User userResponse=userService.updateUser(user);
            if (userResponse!=null) {
                return new ResponseEntity(userResponse, HttpStatus.CREATED );
            }else {
                return new ResponseEntity("Error Occurred", HttpStatus.OK );
            }


        } catch (Exception e){
            log.error("Error Occurred",e);
            return new ResponseEntity("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

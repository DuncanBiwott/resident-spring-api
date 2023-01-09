package com.residentcomplaintmanagement.resident.controller;

import com.residentcomplaintmanagement.resident.model.User;
import com.residentcomplaintmanagement.resident.respository.UserRepository;
import com.residentcomplaintmanagement.resident.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

@RestController
@Slf4j
@RequestMapping("api/resource")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;
    @RequestMapping("/users")
    public ResponseEntity<?> getUsers(){
        try {
            List<User> users=userService.getUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);


        } catch (Exception e){
            log.error("Error Occurred",e);
            return new ResponseEntity<>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/users",method = RequestMethod.POST)
    public ResponseEntity<?> createUsers(@RequestBody  User user ){
        try {
            log.info("User creation request created ");
            User userResponse=userService.createUser(user);
            if (userResponse!=null) {
                return new ResponseEntity<>(userResponse, HttpStatus.CREATED );
            }else {
                return new ResponseEntity<>("No user", HttpStatus.OK );
            }


        } catch (Exception e){
            log.error("Error Occurred",e);
            return new ResponseEntity<>("Error Occured", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("user/{id}")
    public ResponseEntity<?> UpdateUsers(@RequestBody  User user,@PathVariable long id){
        try {
            log.info("User update request");
            Optional<User> user2 = userRepository.findById(id);

            if (!user2.isPresent())
                return new ResponseEntity<>("User does not exist", HttpStatus.NOT_FOUND );


            Optional<User> updated = user2.map(user1 -> {
                user1.setPassword(user.getPassword());
                user1.setName(user.getName());
                user1.setActive(user.getActive());
                return userService.updateUser(user1);
            });

            if (updated.isPresent()) {
                return new ResponseEntity<>(updated.get(), HttpStatus.CREATED );
            }else {
                return new ResponseEntity<>("User does not exist", HttpStatus.NOT_FOUND );
            }


        } catch (Exception e){
            log.error("Error Occurred",e);
            return new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("user/{id}")

    public ResponseEntity<?> deleteUser(@PathVariable("id") long id){
        try {
            log.info("User deleted");
            String userResponds=userService.deleteUser(id);
            if (userResponds.equalsIgnoreCase("Deleted Successfully")){
                return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
            }else {
                return new ResponseEntity<>("Error Occurred",HttpStatus.OK);
            }


        }catch (Exception e){

            log.error("Error Occurred",e);
            return new ResponseEntity<>("Error Occurred", HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
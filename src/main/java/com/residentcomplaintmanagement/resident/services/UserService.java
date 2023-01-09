package com.residentcomplaintmanagement.resident.services;

import com.residentcomplaintmanagement.resident.model.User;
import com.residentcomplaintmanagement.resident.respository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User  createUser(User user){
        try{
            userRepository.save(user);
            return user;

        }catch (Exception e){
            log.error("Error occurred",e);
            return null;
        }
    }

    public User updateUser(User user){

            log.info("Received an update for {}",user.getName());




             userRepository.save(user);


        return user;
    }
    public List<User> getUsers(){
       return userRepository.findAll();

    }
    public String deleteUser(long id){

            userRepository.deleteById(id);
            return  "Deleted Successfully";

        }
    }




package com.stackroute.userservice.controller;


import com.stackroute.userservice.config.JwtTokenGenerator;
import com.stackroute.userservice.exception.IncorrectPasswordException;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;
import com.stackroute.userservice.model.UserDto;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    private UserService userService;
    private JwtTokenGenerator jwtTokenGenerator;

    @GetMapping("welcome")
    public String getWelcome() {
        return "welcome";
    }


    @Autowired
    public UserController(UserService userService, JwtTokenGenerator jwtTokenGenerator) {
        this.userService = userService;
        this.jwtTokenGenerator = jwtTokenGenerator;
    }

    @PostMapping("register")
    public User registerUser(@RequestBody User user) throws UserAlreadyExistsException {

        return this.userService.registerUser(user);
    }


    @GetMapping("findUser/{email}")
    public Object getUserByEmail(@PathVariable("email") String email) throws UserNotFoundException {
        User userEmail = userService.getUserCredentials(email);
        if (userEmail != null) {
            return userEmail;
        }
        return "No valid Register Found";
    }

    @PostMapping("login")
    public ResponseEntity<?> authenticateUser(@RequestBody UserDto userDto) throws UserNotFoundException, IncorrectPasswordException {
        System.out.println("Hello " + userDto);
        final User userr = this.userService.authenticateUser(userDto.getEmail(), userDto.getPassword());
        Map<String, String> map = this.jwtTokenGenerator.generateToken(userr);
        System.out.println(map);
        return ResponseEntity.status(201).body(map);
    }


    @PutMapping("/{email}")
    public ResponseEntity<?> editUser(@PathVariable String email, @RequestBody User user) throws UserNotFoundException {
        try {
            User useer = userService.getUserDetails(email);
            useer.setUsername(user.getUsername());
            useer.setPassword(user.getPassword());
            final User editedUser = this.userService.editUser(useer);
            return new ResponseEntity<User>(editedUser, HttpStatus.OK);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
        }

    }
//    @PutMapping("update/{email}")
//    public ResponseEntity<?> editUser(@PathVariable String email, @RequestBody User user) throws UserNotFoundException {
//        try {
//            User useer = userService.getUserDetails(email);
//            useer.setPassword(user.getPassword());
//            final User editedUser = this.userService.editUser(useer);
//            return new ResponseEntity<User>(editedUser, HttpStatus.OK);
//        } catch (UserNotFoundException e) {
//            return new ResponseEntity<>("USER NOT FOUND", HttpStatus.NOT_FOUND);
//        }
//
//    }

}


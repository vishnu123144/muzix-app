package com.stackroute.userservice.service;
import com.stackroute.userservice.exception.IncorrectPasswordException;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.model.User;

public interface UserService {

    User registerUser(User user) throws UserAlreadyExistsException;

    User authenticateUser(String email, String password) throws UserNotFoundException, IncorrectPasswordException;
    User getUserCredentials(String email);

    User editUser(User user);

    User getUserDetails(String email) throws UserNotFoundException;
}


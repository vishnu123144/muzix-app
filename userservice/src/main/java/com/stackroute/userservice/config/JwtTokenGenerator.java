package com.stackroute.userservice.config;


import com.stackroute.userservice.model.User;

import java.util.Map;

public interface JwtTokenGenerator {

    Map<String,String> generateToken(User user);
}

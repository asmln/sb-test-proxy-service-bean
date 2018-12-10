package com.example.test;

import org.springframework.stereotype.Service;

@Service
public class UserServiceBuilder {

    public UserService build(ConfigBean config) {
        UserService s = new UserService();
        s.name = config.getConfigName();
        return s;
    }

}

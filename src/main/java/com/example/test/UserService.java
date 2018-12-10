package com.example.test;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

//@Service
public class UserService {
    String name;

    //fields omitted
    @Cacheable(value = "user", key = "#name")  //once added, the name will be null.
    public User getUser(String name) {
        System.out.println("--- user creation. this.name = " + this.name);
        return new User(name);
    }

    public String getName() {
        return name;
    }

}

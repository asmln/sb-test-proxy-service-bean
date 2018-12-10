package com.example.test;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

// @Service conflicts with @Bean (TestApplication.userService(...))
// and Spring reports that "The bean 'userService', defined in com.example.test.TestApplication, could not be registered..."
// property spring.main.allow-bean-definition-overriding=true fix this problem, but better to remove annotation @Service from this class
@Service
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

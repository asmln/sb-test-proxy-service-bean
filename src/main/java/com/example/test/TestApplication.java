package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class TestApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Bean
	public UserService UserService(UserServiceBuilder builder, ConfigBean configBean) {
		return builder.build(configBean);
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("--- START");
		System.out.println("--- userService.name: " + userService.name);
		System.out.println("--- userService.getName(): " + userService.getName());
		//user creation
		System.out.println("--- user1 one: " + userService.getUser("USER1"));
		//user with same name from cache
		System.out.println("--- user1 two: " + userService.getUser("USER1"));
	}

}

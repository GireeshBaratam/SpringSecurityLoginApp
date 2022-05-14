package com.app.test.login;

import com.app.test.login.entity.User;
import com.app.test.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;


@SpringBootApplication
public class SignupApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
				  			new User(100, "user", "password", "user@user.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SignupApplication.class, args);
	}

}

package com.web.jpa.JPAproject;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.web.jpa.JPAproject.entity.User;
import com.web.jpa.JPAproject.service.UserDAOService;
import com.web.jpa.JPAproject.service.UserRepository;


@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Yuvan","Admin");
		userRepository.save(user);
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("New user is retrived" + user);
		List<User> users = userRepository.findAll();
		log.info("ALl users" + users);
	}
}
 
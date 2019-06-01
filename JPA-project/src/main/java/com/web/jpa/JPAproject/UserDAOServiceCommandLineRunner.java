package com.web.jpa.JPAproject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.web.jpa.JPAproject.entity.User;
import com.web.jpa.JPAproject.service.UserDAOService;
import com.web.jpa.JPAproject.service.UserRepository;


@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User user = new User("Yuvan","Admin");
		userRepository.save(user);
		log.info("New user is created" + user);
	}
}
 
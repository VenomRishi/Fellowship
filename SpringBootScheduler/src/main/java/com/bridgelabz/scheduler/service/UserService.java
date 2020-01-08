package com.bridgelabz.scheduler.service;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.bridgelabz.scheduler.model.User;
import com.bridgelabz.scheduler.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);
	
	@Scheduled(fixedRate = 5000)
	public void addToDb() {
		User user=new User();
		user.setName("user" + new Random().nextInt(374483));
		repository.save(user);
		System.out.println("add service call in " + new Date().toString());
		
	}
	@Scheduled(cron = "0/15 * * * * *")
	public void fetchFromDb() {
		List<User> users = repository.findAll();
		System.out.println("fetch service call in " + new Date().toString());
		System.out.println("no of record fetched : " + users.size());
		LOG.info("users : {}", users);
	}
}

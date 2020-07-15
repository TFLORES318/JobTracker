package com.skilldistillery.jobtracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilldistillery.jobtracker.entities.User;
import com.skilldistillery.jobtracker.services.UserService;

@RestController
@RequestMapping("api")
public class UserController {
	
	@Autowired
	private UserService userSvc;
	
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userSvc.findAllUsers();
	}

}

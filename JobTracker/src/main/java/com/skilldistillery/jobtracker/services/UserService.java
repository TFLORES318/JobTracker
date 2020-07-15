package com.skilldistillery.jobtracker.services;

import java.util.List;

import com.skilldistillery.jobtracker.entities.User;

public interface UserService {
	
	List<User> findAllUsers();
	
	User findById(int userId);
	
	User findByUsername(String username);
	
	User updateUser(String username, User user);
	
	Boolean deleteUserAccount(String username);

}

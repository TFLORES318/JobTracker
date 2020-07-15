package com.skilldistillery.jobtracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracker.entities.User;
import com.skilldistillery.jobtracker.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	

	@Override
	public User findById(int userId) {
		Optional <User> userOpt = userRepo.findById(userId);
		User user = null;
		if (userOpt.isPresent()) {
			user = userOpt.get();
		}
		return user;
	}

	@Override
	public User findByUsername(String username) {
		User user = userRepo.findByUsername(username);
		if (user != null) {
			return user;
		} 
		return null;
	}

	@Override
	public User updateUser(String username, User user) {
		User managedUser = userRepo.findByUsername(username);
		if (managedUser != null) {
			managedUser.setFirstName(user.getFirstName());
			managedUser.setLastName(user.getLastName());
			managedUser.setPassword(user.getPassword());
			userRepo.saveAndFlush(managedUser);
			return managedUser;
		}
		return null;
	}

	@Override
	public Boolean deleteUserAccount(String username) {
		User deletedUser = userRepo.findByUsername(username);
		boolean deleted = false;
		if (deletedUser != null) {
			userRepo.deleteById(deletedUser.getId());
			return !deleted;
		}
		return deleted;
	}

	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

}

package com.skilldistillery.jobtracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.skilldistillery.jobtracker.entities.User;
import com.skilldistillery.jobtracker.repositories.UserRepository;


@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepository userRepo;
	
	
	@Override
	public User register(User user) {
		String encodedPW = encoder.encode(user.getPassword());
		user.setPassword(encodedPW); // only persist encoded password
		userRepo.saveAndFlush(user);
		return null;
	}

}

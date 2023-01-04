package com.testjavaattornatus.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testjavaattornatus.models.User;
import com.testjavaattornatus.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

}

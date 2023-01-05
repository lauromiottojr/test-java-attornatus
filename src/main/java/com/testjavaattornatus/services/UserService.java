package com.testjavaattornatus.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testjavaattornatus.dtos.UserDTO;
import com.testjavaattornatus.models.User;
import com.testjavaattornatus.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User fromDTO(UserDTO userDTO) {
		return new User(null, userDTO.getName(), userDTO.getBirthDate());
	}

	@Transactional
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

}

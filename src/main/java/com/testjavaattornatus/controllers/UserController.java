package com.testjavaattornatus.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testjavaattornatus.dtos.UserDTO;
import com.testjavaattornatus.models.User;
import com.testjavaattornatus.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO) {
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
	}

	@GetMapping
	public ResponseEntity<List<UserDTO>> findAllUsers() {
		List<User> users = userService.findAllUsers();
		List<UserDTO> usersDTO = users.stream().map(obj -> new UserDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(usersDTO);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> findUserById(@PathVariable(value = "id") Long id) {
		Optional<User> userOptional = userService.findUserById(id);
		if (!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id, @RequestBody @Valid UserDTO userDTO) {
		Optional<User> userOptional = userService.findUserById(id);
		if (!userOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		User user = userOptional.get();
		user.setName(userDTO.getName());
		user.setBirthDate(userDTO.getBirthDate());
		return ResponseEntity.status(HttpStatus.OK).body(userService.saveUser(user));
	}

}

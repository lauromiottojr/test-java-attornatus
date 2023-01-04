package com.testjavaattornatus.controllers;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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

}

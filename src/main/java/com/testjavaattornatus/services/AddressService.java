package com.testjavaattornatus.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.testjavaattornatus.models.Address;
import com.testjavaattornatus.models.User;
import com.testjavaattornatus.repositories.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserService userService;

	@Transactional
	public Address saveAddress(Address address, Long id) {
		Optional<User> userOptional = userService.findUserById(id);
		if (!userOptional.isPresent()) {
			return null;
		}
		address.setUser(userOptional.get());
		address = addressRepository.save(address);
		return address;
	}

}

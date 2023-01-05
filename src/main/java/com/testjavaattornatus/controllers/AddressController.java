package com.testjavaattornatus.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testjavaattornatus.models.Address;
import com.testjavaattornatus.services.AddressService;

@RestController
@RequestMapping(value = "/users")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping("/{id}/address")
	public ResponseEntity<Object> saveAddress(@PathVariable(value = "id") Long id,
			@Valid @RequestBody Address address) {

		address = addressService.saveAddress(address, id);
		if (address == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não encontrado!");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(address);
	}

	@GetMapping("/{id}/address")
	public ResponseEntity<List<Address>> findAddressByUser(@PathVariable(value = "id") Long id) {
		List<Address> addressList = addressService.findAddressByUser(id);
		return ResponseEntity.ok().body(addressList);
	}

}

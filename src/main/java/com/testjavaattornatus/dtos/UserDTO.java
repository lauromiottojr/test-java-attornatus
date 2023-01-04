package com.testjavaattornatus.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.testjavaattornatus.models.Address;
import com.testjavaattornatus.models.User;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@NotBlank
	private String name;

	@JsonFormat(pattern = "dd/MM/yyy")
	@NotNull
	private LocalDate birthDate;

	private List<Address> address = new ArrayList<>();

	public UserDTO() {

	}

	public UserDTO(User user) {
		this.name = user.getName();
		this.birthDate = user.getBirthDate();
		this.address = user.getAddress();
	}

	public UserDTO(@NotBlank String name, @NotBlank LocalDate birthDate, List<Address> address) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public List<Address> getAddress() {
		return address;
	}

	public void setAddress(List<Address> address) {
		this.address = address;
	}

}

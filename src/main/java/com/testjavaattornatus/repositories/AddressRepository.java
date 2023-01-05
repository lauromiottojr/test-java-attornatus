package com.testjavaattornatus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.testjavaattornatus.models.Address;
import com.testjavaattornatus.models.User;

public interface AddressRepository extends JpaRepository<Address, Long> {

	@Transactional(readOnly = true)
	List<Address> findByUser(User user);

}

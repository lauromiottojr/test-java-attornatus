package com.testjavaattornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testjavaattornatus.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}

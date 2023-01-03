package com.testjavaattornatus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testjavaattornatus.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

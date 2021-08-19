package com.empApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empApp.models.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByUsername(String username);

}

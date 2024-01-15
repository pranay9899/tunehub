package com.tunehub.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.app.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

	Users findByEmail(String email);

}

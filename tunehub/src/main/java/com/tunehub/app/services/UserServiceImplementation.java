package com.tunehub.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tunehub.app.entity.Users;
import com.tunehub.app.repository.UsersRepository;

@Service
public class UserServiceImplementation implements UserService {

	@Autowired
	UsersRepository repo;

	@Override
	public boolean addUser(Users user) {
		if (repo.findByEmail(user.getEmail()) == null) {
			repo.save(user);
			return true;
		}
		return false;
	}

	@Override
	public boolean validateUser(String email, String password) {
		Users user = repo.findByEmail(email);
		String passcode = user.getPassword();
		if (passcode == null || password == null || email == null) {
			return false;
		} else if (passcode.equals(password)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getRole(String email) {
		Users user = repo.findByEmail(email);
		String role = user.getRole();
		return role;
	}

	@Override
	public Users getUser(String email) {
		Users user = repo.findByEmail(email);
		return user;
	}

	@Override
	public void updateUser(Users user) {
		repo.save(user);
	}

}

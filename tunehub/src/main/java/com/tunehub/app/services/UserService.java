package com.tunehub.app.services;

import com.tunehub.app.entity.Users;

public interface UserService {

	public boolean addUser(Users user);

	public boolean validateUser(String email, String password);

	public String getRole(String email);

	public Users getUser(String email);

	public void updateUser(Users user);

}

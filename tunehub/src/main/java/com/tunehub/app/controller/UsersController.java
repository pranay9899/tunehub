package com.tunehub.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tunehub.app.entity.Users;
import com.tunehub.app.services.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UsersController {

	@Autowired
	UserService service;

	@PostMapping("/adduser")
	public String addUser(@ModelAttribute Users user) {
		boolean isAdded = service.addUser(user);
		if (isAdded) {
			return "login";
		}
		return "register";
	}

	@PostMapping("/validate")
	public String validate(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session) {
		if (email == null || password == null) {
			return "login";
		}
		if (service.validateUser(email, password)) {
			session.setAttribute("email", email);
			String role = service.getRole(email);
			if (role.equals("admin")) {

				return "adminhome";
			} else if (service.getUser(email).isPremium()) {

				return "customerhome";
			} else {
				return "getpremium";
			}
		}
		return "login";
	}
}

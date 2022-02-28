package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.BaseController;
import com.example.demo.dtos.UserDTO;
import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController extends BaseController<User, UserDTO> {

	public UserController() {
		super(User.class, UserDTO.class);
	}

	@Autowired private UserService userService;
	
}

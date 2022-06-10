package com.example.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.domain.BaseController;
import com.example.sales.dtos.UserDTO;
import com.example.sales.entities.User;
import com.example.sales.services.UserService;

@RestController
@RequestMapping(value = "/usuarios")
public class UserController extends BaseController<User, UserDTO> {

	public UserController() {
		super(User.class, UserDTO.class);
	}

	@Autowired private UserService userService;
	
}

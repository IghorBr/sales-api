package com.example.sales.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.domain.BaseServiceImpl;
import com.example.sales.entities.User;
import com.example.sales.repositories.UserRepository;
import com.example.sales.services.UserService;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

	@Autowired private UserRepository userRepository;
}

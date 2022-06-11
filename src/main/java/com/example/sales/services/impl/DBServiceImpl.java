package com.example.sales.services.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.entities.Address;
import com.example.sales.entities.Product;
import com.example.sales.entities.Purchase;
import com.example.sales.entities.User;
import com.example.sales.entities.enums.UserType;
import com.example.sales.services.ProductService;
import com.example.sales.services.PurchaseService;
import com.example.sales.services.UserService;

@Service
public class DBServiceImpl {

	@Autowired private UserService userService;
	@Autowired private ProductService productService;
	@Autowired private PurchaseService purchaseService;
	
	public void instantiateDevDatabase() {
		
//		User(String email, String username, String name, String lastName, String password, UserType userType)
		
		User user1 = new User("user3@email.com", "user1", "Usuário 1", "Last Name", "123", UserType.USER);
		User user2 = new User("user2@email.com", "user2", "Usuário 2", "Last Name", "123", UserType.USER);
		User user3 = new User("user1@email.com", "user3", "Usuário 3", "Last Name", "123", UserType.USER);
		
		userService.saveAll(Arrays.asList(user1, user2, user3));
		
//		Address(String streetName, Integer number, String uf, String cityName)
		
		Address add1 = new Address("Rua dos Bobos", 0, "RJ", "Rio de Janeiro");
		Address add2 = new Address("Rua dos Bobos", 0, "RJ", "Rio de Janeiro");
		Address add3 = new Address("Rua dos Bobos", 0, "RJ", "Rio de Janeiro");
		
		user1.setAddress(add1);
		user2.setAddress(add2);
		user3.setAddress(add3);
		
		userService.saveAll(Arrays.asList(user1, user2, user3));
		
//		Product(String description, Double price, Integer quantity)
		
		Product prd1 = new Product("O temor do Sábio", 59.99, 15);
		Product prd2 = new Product("Elden Ring", 59.99, 10);
		Product prd3 = new Product("Mi 9T Pro", 1799.99, 5);
		
		productService.saveAll(Arrays.asList(prd1, prd2, prd3));
		
		Purchase p1 = new Purchase(user1);
		p1.addProduct(prd1, 1).addProduct(prd2, 1).addProduct(prd3, 1);
		
		Purchase p2 = new Purchase(user2);
		p2.addProduct(prd1, 2).addProduct(prd2, 1).addProduct(prd3, 3);
		
		purchaseService.saveAll(Arrays.asList(p1, p2));
		productService.saveAll(Arrays.asList(prd1, prd2, prd3));
		
	}
	
}

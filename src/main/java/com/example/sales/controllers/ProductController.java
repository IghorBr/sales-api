package com.example.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.domain.BaseController;
import com.example.sales.dtos.ProductDTO;
import com.example.sales.entities.Product;
import com.example.sales.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController extends BaseController<Product, ProductDTO> {

	public ProductController() {
		super(Product.class, ProductDTO.class);
	}
	
	@Autowired private ProductService productService;
}

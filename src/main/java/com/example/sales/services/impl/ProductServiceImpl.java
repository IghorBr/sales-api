package com.example.sales.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.domain.BaseServiceImpl;
import com.example.sales.entities.Product;
import com.example.sales.repositories.ProductRepository;
import com.example.sales.services.ProductService;

@Service
public class ProductServiceImpl extends BaseServiceImpl<Product> implements ProductService {
	
	@Autowired private ProductRepository productRepository;

}

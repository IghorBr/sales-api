package com.example.sales.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.sales.domain.BaseServiceImpl;
import com.example.sales.dtos.NewPurchaseDTO;
import com.example.sales.dtos.PaymentDTO;
import com.example.sales.dtos.ProductQuantityDTO;
import com.example.sales.entities.Product;
import com.example.sales.entities.Purchase;
import com.example.sales.entities.User;
import com.example.sales.repositories.PurchaseRepository;
import com.example.sales.services.ProductService;
import com.example.sales.services.PurchaseService;
import com.example.sales.services.UserService;

import reactor.core.publisher.Mono;

@Service
public class PurchaseServiceImpl extends BaseServiceImpl<Purchase> implements PurchaseService {

	@Autowired private PurchaseRepository purchaseRepository;
	@Autowired private UserService userService;
	@Autowired private ProductService productService;

	@Override
	@Transactional
	public Purchase createPurchase(NewPurchaseDTO dto) throws Exception {
		User u = userService.findById(3L).orElseThrow(() -> new Exception());;
		
		Purchase purchase = new Purchase(u);
		purchase.setDiscount(dto.getDiscount());
		for (ProductQuantityDTO pq : dto.getItens()) {
			Product product = productService.findById(pq.getProductId()).orElseThrow(() -> new Exception());
			purchase = purchase.addProduct(product, pq.getQuantity());
			
			productService.update(product);
		}
		
		
		PaymentDTO paymentDTO = new PaymentDTO(u.getEmail(), purchase.getTotal());
		
		WebClient client = WebClient.create("http://localhost:8080");
		Boolean response = client.post()
									.uri("/accounts/verify-acc")
									.body(Mono.just(paymentDTO), PaymentDTO.class)
									.retrieve()
									.bodyToMono(Boolean.class)
									.block();
		
		if (response)
			purchase = purchaseRepository.save(purchase);
		else
			throw new Exception("Valor muito alto");
		
		return purchase;
	}
}

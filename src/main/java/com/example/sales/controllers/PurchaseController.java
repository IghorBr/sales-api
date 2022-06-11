package com.example.sales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sales.domain.BaseController;
import com.example.sales.dtos.NewPurchaseDTO;
import com.example.sales.dtos.PurchaseDTO;
import com.example.sales.entities.Purchase;
import com.example.sales.services.PurchaseService;

@RestController
@RequestMapping(value = "/purchases")
public class PurchaseController extends BaseController<Purchase, PurchaseDTO> {

	public PurchaseController() {
		super(Purchase.class, PurchaseDTO.class);
	}

	@Autowired private PurchaseService purchaseService;
	
	@PostMapping(value = "/new-buy")
	public ResponseEntity<Void> createPurchase(@RequestBody NewPurchaseDTO dto) throws Exception {
		purchaseService.createPurchase(dto);
		
		return ResponseEntity.noContent().build();
	}
	
}

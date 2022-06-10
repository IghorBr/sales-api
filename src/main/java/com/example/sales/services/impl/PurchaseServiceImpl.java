package com.example.sales.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sales.domain.BaseServiceImpl;
import com.example.sales.entities.Purchase;
import com.example.sales.repositories.PurchaseRepository;
import com.example.sales.services.PurchaseService;

@Service
public class PurchaseServiceImpl extends BaseServiceImpl<Purchase> implements PurchaseService {

	@Autowired private PurchaseRepository purchaseRepository;
}

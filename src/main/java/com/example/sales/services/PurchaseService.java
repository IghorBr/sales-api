package com.example.sales.services;

import com.example.sales.domain.BaseService;
import com.example.sales.dtos.NewPurchaseDTO;
import com.example.sales.entities.Purchase;

public interface PurchaseService extends BaseService<Purchase> {

	Purchase createPurchase(NewPurchaseDTO dto) throws Exception;
}

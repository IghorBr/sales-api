package com.example.sales.repositories;

import org.springframework.stereotype.Repository;

import com.example.sales.domain.BaseRepository;
import com.example.sales.entities.Purchase;

@Repository
public interface PurchaseRepository extends BaseRepository<Purchase> {

}

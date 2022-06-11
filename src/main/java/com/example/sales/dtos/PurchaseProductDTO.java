package com.example.sales.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class PurchaseProductDTO implements Serializable {
	private static final long serialVersionUID = -8199681871971119984L;
	
	private Integer quantity;
	private Double price;
	
	private Long productId;
}

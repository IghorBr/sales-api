package com.example.sales.dtos;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class NewPurchaseDTO implements Serializable {
	private static final long serialVersionUID = 795338746105928133L;

	private Double discount = 0.;
	private List<ProductQuantityDTO> itens;
	
}
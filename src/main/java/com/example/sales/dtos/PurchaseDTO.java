package com.example.sales.dtos;

import java.util.Date;
import java.util.Set;

import com.example.sales.domain.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class PurchaseDTO extends BaseDTO {
	private static final long serialVersionUID = 5197119869252510666L;
	
	private Date boughtAt;
	private Double total;
	private UserDTO user;
	
	private Set<PurchaseProductDTO> itens;
}

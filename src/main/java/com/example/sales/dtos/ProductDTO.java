package com.example.sales.dtos;

import com.example.sales.domain.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ProductDTO extends BaseDTO {
	private static final long serialVersionUID = -5282914130587894129L;
	
	private String description;
	private Double price;
	private Integer quantity;

}

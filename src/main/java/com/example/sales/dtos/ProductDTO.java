package com.example.sales.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.example.sales.domain.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ProductDTO extends BaseDTO {
	private static final long serialVersionUID = -5282914130587894129L;
	
	@NotEmpty private String description;
	@NotNull private Double price;
	@NotNull private Integer quantity;

}

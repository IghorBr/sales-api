package com.example.sales.dtos;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class ProductQuantityDTO implements Serializable {
	private static final long serialVersionUID = -4168099397038237063L;

	private Long productId;
	private Integer quantity;
}
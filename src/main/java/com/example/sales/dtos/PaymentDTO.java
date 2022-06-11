package com.example.sales.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@AllArgsConstructor
public class PaymentDTO implements Serializable {
	private static final long serialVersionUID = 2434289823465436680L;
	
	private String email;
	private Double value;
}

package com.example.sales.dtos;

import com.example.sales.domain.BaseDTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddressDTO extends BaseDTO {
	private static final long serialVersionUID = -6542575477188651965L;

	private String streetName;
	private Integer number;
	private String uf;
	private String cityName;
	
}

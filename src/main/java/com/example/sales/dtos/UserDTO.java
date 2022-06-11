package com.example.sales.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.example.sales.domain.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class UserDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	@NotEmpty private String name;
	@NotEmpty private String username;
	@NotEmpty private String lastName;
	@NotEmpty @Email private String email;
	@NotEmpty private String userType;
	
	private AddressDTO address;
}

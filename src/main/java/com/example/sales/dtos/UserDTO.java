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
	
	@NotEmpty private String nome;
	@NotEmpty private String sobrenome;
	@NotEmpty @Email private String email;
	@NotEmpty private String senha;
}

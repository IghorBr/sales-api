package com.example.sales.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.example.sales.domain.BaseDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Product extends BaseDomain {

	@PrePersist
	@PreUpdate
	void verificaQuantidade() throws Exception {
		if (quantity < 0)
			throw new Exception("Quantidade menor que 0");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;
	
	private String description;
	private Double price;
	private Integer quantity;
	
	public Product(String description, Double price, Integer quantity) {
		super();
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}

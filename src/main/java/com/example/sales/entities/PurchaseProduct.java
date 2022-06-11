package com.example.sales.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class PurchaseProduct {
	
	@EmbeddedId
	private PurchaseProductPK id = new PurchaseProductPK();
	
	private Integer quantity;
	private Double price;
	
	public Double getSubTotal() {
		return price * quantity;
	}
	
	public Purchase getPurchase() {
		return this.id.getPurchase();
	}
	
	public Product getProduct() {
		return this.id.getProduct();
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	public PurchaseProduct(Purchase purchase, Product product, Integer quantity) {
		this.id.setPurchase(purchase);
		this.id.setProduct(product);
		this.quantity = quantity;
		this.price = product.getPrice();
		
		product.setQuantity(product.getQuantity() - quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseProduct other = (PurchaseProduct) obj;
		return Objects.equals(id, other.id);
	}
	
}

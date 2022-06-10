package com.example.sales.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter @Setter
public class PurchaseProductPK implements Serializable {
	private static final long serialVersionUID = -8204461704764323105L;

	@ManyToOne
	@JoinColumn(name = "purchase_id")
	private Purchase purchase;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	@Override
	public int hashCode() {
		return Objects.hash(product, purchase);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseProductPK other = (PurchaseProductPK) obj;
		return Objects.equals(product, other.product) && Objects.equals(purchase, other.purchase);
	}
	
	
}

package com.example.sales.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import com.example.sales.domain.BaseDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Purchase extends BaseDomain {
	
	@PrePersist
	private void prePersist() {
		this.boughtAt = new Date();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "bought_at")
	private Date boughtAt;
	
	@OneToMany(mappedBy = "id.purchase", cascade = CascadeType.ALL)
	private Set<PurchaseProduct> itens = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
	
	public Purchase(User user) {
		super();
		this.user = user;
	}
	
	public Purchase addProduct(Product p, Double discount, Integer amount) {
		PurchaseProduct pp = new PurchaseProduct(this, p, discount, amount);
		itens.add(pp);
		return this;
	}
	
	public Double getTotal() {
		double amount = 0.0;
		for (PurchaseProduct pp : itens)
			amount += pp.getSubTotal();
		
		return amount;
	}
	
}

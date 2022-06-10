package com.example.sales.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.sales.domain.BaseDomain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class Address extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Long id;
	
	@Column(name = "street_name")
	private String streetName;
	
	private Integer number;
	
	private String uf;
	
	@Column(name = "city_name")
	private String cityName;

	public Address(String streetName, Integer number, String uf, String cityName) {
		super();
		this.streetName = streetName;
		this.number = number;
		this.uf = uf;
		this.cityName = cityName;
	}
	
	
	
}

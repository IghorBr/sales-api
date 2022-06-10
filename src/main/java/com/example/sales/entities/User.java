package com.example.sales.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

import com.example.sales.domain.BaseDomain;
import com.example.sales.entities.enums.UserType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter @Setter
public class User extends BaseDomain {
	
	@PrePersist
	void prePersist() {
		this.createdAt = new Date();
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String username;
	
	private String name;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String password;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "user_type")
	@Enumerated(EnumType.STRING)
	private UserType userType;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;
	
	@OneToMany(mappedBy = "user")
	private Set<Purchase> purchase = new HashSet<>();

	public User(String email, String username, String name, String lastName, String password, UserType userType) {
		super();
		this.email = email;
		this.username = username;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.userType = userType;
	}
	
	
}

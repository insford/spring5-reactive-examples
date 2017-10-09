package com.insford.spring5.domain;

import java.util.List;

public class User {
	private Long id;
	private String name;
	private List<Customer> customers;

	public User(Long id, String name, List<Customer> customers) {
		this.id = id;
		this.name = name;
		this.customers = customers;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

}

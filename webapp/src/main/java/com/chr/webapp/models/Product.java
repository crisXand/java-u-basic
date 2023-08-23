package com.chr.webapp.models;

import java.util.Objects;

public class Product {
	private int id;
	private String name;
	private double price;
	private String tipo;
	
	public Product() {
		super();
	}

	public Product(int id, String name, double price, String tipo) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.tipo = tipo;
	}

	public String getName() {
		return name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	
}

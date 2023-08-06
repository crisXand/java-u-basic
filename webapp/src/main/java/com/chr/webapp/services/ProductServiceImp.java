package com.chr.webapp.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.chr.webapp.models.Product;

public class ProductServiceImp implements ProductService{
	
	List<Product> products = new ArrayList<>();
	
	
	
	public ProductServiceImp() {
		products = Arrays.asList(
				new Product(1, "Tv", 123.5, "Tecnologie"),
				new Product(2, "Laptop Hp", 133.5, "Tecnologie")
				);
				
	}

	@Override
	public List<Product> findAll() {
		
		return products;
	}

	@Override
	public Product find(int id){
		// TODO Auto-generated method stub
		return products.stream().filter(p -> p.getId() == id ).findAny().get();
	}

}

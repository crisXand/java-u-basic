package com.chr.webapp.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.chr.webapp.models.Product;
import com.chr.webapp.repositories.ProductRepository;

public class ProductServiceImp implements ProductService{
	
	List<Product> products = new ArrayList<>();
	
	Connection connection;
	ProductRepository productRepository;
	
	public ProductServiceImp(Connection connection) {
		this.connection = connection;
		productRepository = new ProductRepository(this.connection);
		
	}


	@Override
	public List<Product> findAll() {
		try {
			products =  productRepository.findAll();
			return products;
			
		}catch (SQLException e) {
			// TODO: handle exception
			throw new ServiceJdbcException(e.getMessage(), e.getCause());
		}
		
		
	}

	@Override
	public Optional<Product> find(int id) {
		// TODO Auto-generated method stub
		try {
			return Optional.ofNullable(productRepository.find(id));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new ServiceJdbcException(e.getMessage(), e.getCause());
		}
		
		//return products.stream().filter(p -> p.getId() == id ).findAny();
	}

}

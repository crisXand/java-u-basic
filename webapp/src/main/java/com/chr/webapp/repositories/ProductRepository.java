package com.chr.webapp.repositories;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.chr.webapp.models.Product;


public class ProductRepository implements Repository<Product> {
	Connection connection;
	
	public ProductRepository(Connection con) {
		connection = con;
	}
	
	@Override
	public List<Product> findAll() throws SQLException{
		// TODO Auto-generated method stub
		List<Product> listProducts = new ArrayList<>();
		try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery("SELECT * FROM productos");
			while (resultSet.next()) {
				
				listProducts.add(castToProductClas(resultSet));
			}
		}
		return listProducts;
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		
	}
	
	public Product find(int id) throws SQLException {
		Product product = null;
		try(PreparedStatement statement = connection.prepareStatement("Select * from productos p where p.id = ?")){
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery()){
				if(resultSet.next()) {
					product = castToProductClas(resultSet);
				}
			}
		}
		return product;
	}
	
	private Product castToProductClas(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		Product product = new Product();
		product.setId(resultSet.getInt("id"));
		product.setName(resultSet.getString("product_name"));
		product.setPrice(resultSet.getDouble("price"));
		
		return product;
	}
}

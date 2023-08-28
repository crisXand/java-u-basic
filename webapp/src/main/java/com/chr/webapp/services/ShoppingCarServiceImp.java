package com.chr.webapp.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

import com.chr.webapp.models.CarItem;
import com.chr.webapp.models.Product;

public class ShoppingCarServiceImp implements ShoppingCarService{
	Connection connection;
	
	public ShoppingCarServiceImp(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Optional<CarItem> addCarItem(int idProduct) {
		// TODO Auto-generated method stub
		ProductService ps = new ProductServiceImp(connection);
		Optional<Product> p = ps.find(idProduct);
		if(p.isPresent()) {
			System.out.println(p.get().getId());
			return Optional.of( new CarItem(1, p .get()));
		}
		return Optional.empty();
		
		
	}

}

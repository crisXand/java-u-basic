package com.chr.webapp.services;

import java.sql.SQLException;
import java.util.List;

import com.chr.webapp.models.Product;

public interface ProductService{
	List<Product> findAll() ;
	Product find( int id ) ;
}

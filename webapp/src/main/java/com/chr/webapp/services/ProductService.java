package com.chr.webapp.services;

import java.util.List;
import java.util.Optional;

import com.chr.webapp.models.Product;

public interface ProductService{
	List<Product> findAll() ;
	Optional<Product> find( int id ) ;
}

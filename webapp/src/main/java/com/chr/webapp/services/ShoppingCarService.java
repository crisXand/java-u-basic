package com.chr.webapp.services;

import java.sql.SQLException;
import java.util.Optional;

import com.chr.webapp.models.CarItem;


public interface ShoppingCarService {
	Optional<CarItem> addCarItem(int idProduct) ;
}

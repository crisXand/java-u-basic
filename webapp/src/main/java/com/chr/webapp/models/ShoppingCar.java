package com.chr.webapp.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCar {
	List<CarItem> car;

	public ShoppingCar() {
		car = new ArrayList<>();
	}

	public List<CarItem> getCar() {
		return car;
	}
	
	public void addToCar(CarItem c) {
		if(car.contains(c)) {
			Optional<CarItem> itemCarOptional = car.stream().filter(item-> item.equals(c)).findAny();
			CarItem itemCar= itemCarOptional.get();
			itemCar.setAmount(itemCar.getAmount() + 1);
		}else {
			car.add(c);
		}
		
	}
	
	public double getTotal() {
		return car.stream().mapToDouble(i -> i.getItemTotal()).sum();
	}
}

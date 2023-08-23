package com.chr.webapp.session.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.util.Optional;


import com.chr.webapp.services.ShoppingCarService;
import com.chr.webapp.services.ShoppingCarServiceImp;
import com.chr.webapp.models.CarItem;

import com.chr.webapp.models.ShoppingCar;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/shopping/add-product")
public class AddToCarServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int productId = Integer.parseInt(req.getParameter("id"));
		ShoppingCarService s = new ShoppingCarServiceImp((Connection) req.getAttribute("connection"));
		Optional<CarItem> item = s.addCarItem(productId);
		if(item.isPresent()) {
			HttpSession session = req.getSession();
			ShoppingCar car = (ShoppingCar) session.getAttribute("car");
			
			car.addToCar(item.get());
		}
		resp.sendRedirect(req.getContextPath() + "/shopping/shopping-car");
	}
	
}

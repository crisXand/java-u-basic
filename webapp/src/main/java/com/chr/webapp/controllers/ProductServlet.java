package com.chr.webapp.controllers;

import java.io.IOException;
import java.sql.Connection;

import com.chr.webapp.services.ProductService;
import com.chr.webapp.services.ProductServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/products")
public class ProductServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductService productService = new ProductServiceImp((Connection)req.getAttribute("connection"));
		req.setAttribute("products", productService.findAll());
		getServletContext().getRequestDispatcher("/product.jsp").forward(req, resp);
	}
	
}

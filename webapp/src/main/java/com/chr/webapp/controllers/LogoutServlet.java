package com.chr.webapp.controllers;

import java.io.IOException;
import java.util.Optional;

import com.chr.webapp.services.LoginService;
import com.chr.webapp.services.LoginServiceImp;
import com.chr.webapp.services.LoginSessionServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService ls = new LoginSessionServiceImpl();
		Optional<String> username = ls.getUser(req, "username");
		if(username.isPresent()) {
			HttpSession session = req.getSession();
			session.invalidate();
		}
		resp.sendRedirect(req.getContextPath() + "/login");
	
	}
	
}

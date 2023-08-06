package com.chr.webapp.controllers;

import java.io.IOException;
import java.util.Optional;

import com.chr.webapp.services.LoginService;
import com.chr.webapp.services.LoginServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LoginService ls = new LoginServiceImp();
		Optional<Cookie> userCookie = ls.getCookie(req, "username");
		if(userCookie.isPresent()) {
			ls.getCookie(req, "username").get().setMaxAge(0);
			resp.addCookie(userCookie.get());
		}
		resp.sendRedirect(req.getContextPath() + "/login");
	
	}
	
}

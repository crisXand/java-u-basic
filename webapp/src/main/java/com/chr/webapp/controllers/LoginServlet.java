package com.chr.webapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;

import com.chr.webapp.services.LoginService;
import com.chr.webapp.services.LoginServiceImp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.MediaType;

@WebServlet({"/login"})
public class LoginServlet extends HttpServlet{
	final static String USERNAME = "crisandro";
	final static String PASSWORD = "12345";
	
		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			LoginService auth = new LoginServiceImp();
			Optional<Cookie> cookieOptional = auth.getCookie(req, "username");
			if( cookieOptional.isPresent()) {
				try( PrintWriter out = resp.getWriter()){
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("	<head>");
					out.println("       <meta charset=\"UTF-8\">");
					out.println("		<title> Login </title>");
					out.println("	</head>");
					out.println("	<body>");
					out.println("		<h1>Login</h1>");
					out.println("		<h3>Usted esta logueado como "+ cookieOptional.get().getValue() + "</h3>");
					out.println("	</body>");
					out.println("</html>");
					
				}
			}else getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(USERNAME.equals(username) && PASSWORD.equals(pass)) {
			Cookie usernameCookie = new Cookie("username", username);
			resp.addCookie(usernameCookie);
			
			resp.sendRedirect(req.getContextPath() + "/login");
		}else {
			getServletContext().getRequestDispatcher("login.jsp");
		}
		
	}
	
}

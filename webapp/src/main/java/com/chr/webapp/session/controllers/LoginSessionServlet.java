	package com.chr.webapp.session.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
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
import jakarta.ws.rs.core.MediaType;

@WebServlet({"/session/login"})
public class LoginSessionServlet extends HttpServlet{
	final static String USERNAME = "crisandro";
	final static String PASSWORD = "12345";
	
		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			LoginService auth = new LoginSessionServiceImpl();
			Optional<String> sesion = auth.getUser(req, "user");
			if( sesion.isPresent()) {
				try( PrintWriter out = resp.getWriter()){
					out.println("<!DOCTYPE html>");
					out.println("<html>");
					out.println("	<head>");
					out.println("       <meta charset=\"UTF-8\">");
					out.println("		<title> Login </title>");
					out.println("	</head>");
					out.println("	<body>");
					out.println("		<h1>Login</h1>");
					out.println("		<h3>Usted esta logueado como "+ sesion.get() + "</h3>");
					out.println("		<a href=\"" + req.getContextPath() + "/products\">Products</a>");
					out.println("	</body>");
					out.println("</html>");
					
				}
			}else getServletContext().getRequestDispatcher("/loginsession.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if(USERNAME.equals(username) && PASSWORD.equals(pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("user", username);
			
			resp.sendRedirect(req.getContextPath() + "/session/login");
		}else {
			getServletContext().getRequestDispatcher("login.jsp");
		}
		
	}
	
}

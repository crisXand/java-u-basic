package com.chr.webapp.listener;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class AplicationAppContextListener implements ServletContextListener{
	private ServletContext context;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		sce.getServletContext().log("Inicializando la webapp");
		context = sce.getServletContext();
		context.setAttribute("contextAttribute", "Un mensaje");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		sce.getServletContext().log("Destruyendo la webapp");
	}
	
}

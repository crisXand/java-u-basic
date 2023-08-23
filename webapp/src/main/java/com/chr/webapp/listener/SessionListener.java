package com.chr.webapp.listener;

import com.chr.webapp.models.ShoppingCar;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
@WebListener
public class SessionListener implements HttpSessionListener{
	
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		HttpSession session = se.getSession();
		ShoppingCar car = new ShoppingCar();
		session.setAttribute("car", car);
		System.out.println("Inicializando sesion");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
		
		System.out.println("Finalizando session");
	}
	
}

package com.chr.webapp.listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
@WebListener
public class RequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		sre.getServletContext().log("Finalizando request");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		sre.getServletContext().log("Inicializando request");
		
		sre.getServletRequest().setAttribute("requestAttribute", "valor");
	}
	
}

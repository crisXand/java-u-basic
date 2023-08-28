package com.chr.webapp.filters;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import com.chr.webapp.services.ServiceJdbcException;
import com.chr.webapp.utils.*;
@WebFilter("/*")
public class ConnectionFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try(Connection connection = ConnectionDb.getInstance()) { //sirve solo para cerrar la connecion
			
			if (connection.getAutoCommit()) {
				connection.setAutoCommit(false);
			}
			
			try {
				request.setAttribute("connection", connection);
				chain.doFilter(request, response);
				connection.commit();
			} catch (SQLException | ServiceJdbcException e) { //debemos manejar la excepcion creada 
				
				connection.rollback();
				((HttpServletResponse) response).sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
				// TODO: handle exception
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
}

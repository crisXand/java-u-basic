package com.chr.webapp.filters;

import java.io.IOException;
import java.util.Optional;

import com.chr.webapp.services.LoginService;
import com.chr.webapp.services.LoginServiceImp;
import com.chr.webapp.services.LoginSessionServiceImpl;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter({"/shopping/*"})
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LoginService loginService = new LoginSessionServiceImpl();
		Optional<String> user = loginService.getUser((HttpServletRequest)request, "user");
		if(user.isPresent()) {
			chain.doFilter(request, response);
		}else {
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_UNAUTHORIZED,"Usuario no autorizado");
			
		}
	}

}

package com.chr.webapp.services;

import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class LoginSessionServiceImpl implements LoginService {

	@Override
	public Optional<String> getUser(HttpServletRequest req, String nameAttribute) {
		// TODO Auto-generated method stub
		String username = (String) req.getSession().getAttribute(nameAttribute);
		System.out.println(username);
		if(username != null) {
			return Optional.of(username); 
		}
		return Optional.empty();
	}

}

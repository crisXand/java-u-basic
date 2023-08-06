package com.chr.webapp.services;

import java.util.Arrays;
import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class LoginServiceImp implements LoginService{

	@Override
	public Optional<Cookie> getCookie(HttpServletRequest req, String cookieName) {
		Cookie[] cookies = req.getCookies() != null ? req.getCookies(): new Cookie[0];
		return  Arrays.stream(cookies)
				.filter(c -> cookieName.equals(c.getName())).findAny();
	}

}

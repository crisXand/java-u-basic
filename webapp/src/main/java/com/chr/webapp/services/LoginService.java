package com.chr.webapp.services;

import java.util.Optional;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public interface LoginService {
	Optional<Cookie> getCookie(HttpServletRequest req, String cookieName);
}

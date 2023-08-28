package com.chr.webapp.services;

public class ServiceJdbcException extends RuntimeException{
	public ServiceJdbcException(String message) {
		super(message);
	}
	public ServiceJdbcException(String message, Throwable e) {
		super(message, e);
	}
}

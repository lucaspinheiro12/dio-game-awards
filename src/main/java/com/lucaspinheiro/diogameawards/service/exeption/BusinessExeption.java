package com.lucaspinheiro.diogameawards.service.exeption;

public class BusinessExeption extends RuntimeException {

	private static final long serialVersion = 1L;
	
	public BusinessExeption (String message) {
		super(message);
	}
}

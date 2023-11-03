package com.lucaspinheiro.diogameawards.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lucaspinheiro.diogameawards.service.exeption.BusinessExeption;
import com.lucaspinheiro.diogameawards.service.exeption.NoContentExeption;

@RequestMapping("/api")
public abstract class BaseRestController {
	
	@ExceptionHandler(NoContentExeption.class)
	public ResponseEntity<Void> handlerNoContent(NoContentExeption exception){
		return ResponseEntity.noContent().build();
	}
	
	@ExceptionHandler(BusinessExeption.class)
	public ResponseEntity<ApiErrorDTO> handlerBusinessException(BusinessExeption exception){
		ApiErrorDTO error = new ApiErrorDTO(exception.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<ApiErrorDTO> handlerUnexpectedBusinessException(BusinessExeption exception){
		ApiErrorDTO error = new ApiErrorDTO("Ops, ocorreu um erro inesperado.");
		return ResponseEntity.internalServerError().body(error);
	}
}

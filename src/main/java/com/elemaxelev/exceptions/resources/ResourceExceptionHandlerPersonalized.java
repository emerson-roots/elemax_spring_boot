package com.elemaxelev.exceptions.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.elemaxelev.exceptions.services.ObjectNotFoundExceptionPersonalized;

@ControllerAdvice
public class ResourceExceptionHandlerPersonalized {

	@ExceptionHandler(ObjectNotFoundExceptionPersonalized.class)
	public ResponseEntity<StandardErrorPersonalized> objectNotFoundPersonalized(
			ObjectNotFoundExceptionPersonalized pNotFound, HttpServletRequest pRequest) {

		StandardErrorPersonalized err = new StandardErrorPersonalized(System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(), "Objeto não encontrado", pNotFound.getMessage(),
				pRequest.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

}

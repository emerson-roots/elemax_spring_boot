package com.elemaxelev.exceptions.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardErrorPersonalized> validationPersonalized(MethodArgumentNotValidException e,
			HttpServletRequest pRequest) {

		ValidationErrorPersonalized err = new ValidationErrorPersonalized(System.currentTimeMillis(),
				HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação de campos", e.getMessage(),
				pRequest.getRequestURI());

		// percorre cada erro adicionando ao metodo personalizado addError
		for (FieldError x : e.getBindingResult().getFieldErrors()) {
			err.addError(x.getField(), x.getDefaultMessage());
		}
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
	}

}

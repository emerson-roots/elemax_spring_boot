package com.elemaxelev.exceptions.services;


public class ObjectNotFoundExceptionPersonalized extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundExceptionPersonalized(String pMensagemExcessao) {
		super(pMensagemExcessao);
	}
	
	public ObjectNotFoundExceptionPersonalized(String pMensagem, Throwable pCause) {
		super(pMensagem, pCause);
	}

}

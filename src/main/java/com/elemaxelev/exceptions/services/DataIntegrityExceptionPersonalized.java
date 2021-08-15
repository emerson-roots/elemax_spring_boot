package com.elemaxelev.exceptions.services;


public class DataIntegrityExceptionPersonalized extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrityExceptionPersonalized(String pMensagemExcessao) {
		super(pMensagemExcessao);
	}
	
	public DataIntegrityExceptionPersonalized(String pMensagem, Throwable pCause) {
		super(pMensagem, pCause);
	}

}

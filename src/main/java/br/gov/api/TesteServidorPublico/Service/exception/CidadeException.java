package br.gov.api.TesteServidorPublico.Service.exception;

public class CidadeException extends Exception {
	private static final long serialVersionUID = 1L;

	public CidadeException(String message, Throwable cause) {
		super(message, cause);
	}

	public CidadeException(String message) {
		super(message);
	}
}

package br.gov.api.TesteServidorPublico.Service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ServidorEfetivoException extends Exception {

	public ServidorEfetivoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServidorEfetivoException(String message) {
		super(message);
	}

}

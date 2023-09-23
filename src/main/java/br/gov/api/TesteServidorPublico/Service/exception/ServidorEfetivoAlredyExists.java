package br.gov.api.TesteServidorPublico.Service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.CONFLICT)
public class ServidorEfetivoAlredyExists extends Exception {

	public ServidorEfetivoAlredyExists(String message, Throwable cause) {
		super(message, cause);
	}

	public ServidorEfetivoAlredyExists(String message) {
		super(message);
	}

}

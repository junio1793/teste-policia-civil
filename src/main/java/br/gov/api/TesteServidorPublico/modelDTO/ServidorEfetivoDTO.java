package br.gov.api.TesteServidorPublico.modelDTO;

import br.gov.api.TesteServidorPublico.Model.ServidorEfetivo;
import lombok.Data;

@Data
public class ServidorEfetivoDTO {

	private Long id;
	private String matricula;
	
	
	public ServidorEfetivoDTO(ServidorEfetivo efetivo) {
		super();
		this.id = efetivo.getId();
		this.matricula = efetivo.getMatricula();
	}
	
	public ServidorEfetivoDTO() {
	}
}

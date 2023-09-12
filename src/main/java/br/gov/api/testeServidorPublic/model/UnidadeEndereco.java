package br.gov.api.testeServidorPublic.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UnidadeEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ue_id;
	private Unidade unidade;
	private Endereco endereco;
}

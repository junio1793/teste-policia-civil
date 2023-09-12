package br.gov.api.testeServidorPublic.model;

import java.sql.Date;

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
public class Lotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lot_id;
	private Date lot_data_lotacao;
	private Date lot_data_remocao;
	private String lot_portaria;
	private Pessoa pessoa;
	private Unidade unidade;
	
}

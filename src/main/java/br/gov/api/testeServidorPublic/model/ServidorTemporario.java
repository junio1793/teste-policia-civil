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
public class ServidorTemporario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long st_id;
	private Pessoa pessoa;
	private Date st_admissao;
	private Date st_demissao;

}

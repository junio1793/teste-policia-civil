package br.gov.api.TesteServidorPublico.Model;

import java.io.Serializable;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Unidade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="unid_nome")
	private String nome;

	@Column(name="unid_sigla")
	private String sigla;

	@OneToOne(mappedBy = "unidade")
	private Lotacao  lotacao;


}

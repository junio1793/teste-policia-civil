package br.gov.api.testeServidorPublic.model;

import java.io.Serializable;
import java.util.List;

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
	private Long unid_id;
	private String unid_nome;
	private String unid_sigla;

	@ManyToMany
	@JoinTable(
			name = "unidade_endereco",
			joinColumns = @JoinColumn(name = "id_unidade" ),
			inverseJoinColumns = @JoinColumn(name="id_endereco")
	)
	private List<Endereco> enderecoList;
}

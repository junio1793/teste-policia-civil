package br.gov.api.TesteServidorPublico.modelDTO;

import java.sql.Date;

import br.gov.api.TesteServidorPublico.Model.Pessoa;
import lombok.Data;

@Data
public class PessoaDTO {

	private Long id;

	private String nome;

	private Date dataNascimento;

	private String sexo;

	private String pai;

	private String mae;

	public PessoaDTO(Pessoa pessoa) {
		super();
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.dataNascimento = pessoa.getDataNascimento();
		this.sexo = pessoa.getSexo();
		this.pai = pessoa.getPai();
		this.mae = pessoa.getMae();
	}

	public PessoaDTO() {
	}

}

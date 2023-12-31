package br.gov.api.TesteServidorPublico.Model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="pes_nome")
	private String nome;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="pes_data_nasc")
	private Date dataNascimento;
	
	
	@Column(name="pes_sexo")
	private String sexo;
	
	@Column(name="pes_pai")
	private String pai;
	
	@Column(name="pes_mae")
	private String mae;

	@OneToOne(mappedBy = "pessoa")
	private PessoaEndereco pessoaEndereco;

	@OneToMany(mappedBy = "pessoa")
	private List<FotoPessoa> fotoPessoa  = new ArrayList<>();

	@OneToOne(mappedBy = "pessoa")
	private ServidorTemporario servidorTemporario;

	@OneToOne(mappedBy="pessoa")
	private Lotacao lotacao;


}

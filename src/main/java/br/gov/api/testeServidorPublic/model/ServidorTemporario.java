package br.gov.api.testeServidorPublic.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ServidorTemporario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="st_admissao")
	private Date admissao;
	@Column(name="st_demissao")
	private Date demissao;
	@OneToMany
	@JoinColumn(name = "id_pessoa")
	private List<Pessoa> pessoa = new ArrayList<>();
}

package br.gov.api.TesteServidorPublico.Model;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class ServidorTemporario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="st_admissao")
	private Date admissao;
	@Column(name="st_demissao")
	private Date demissao;
	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa ;
}

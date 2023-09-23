package br.gov.api.TesteServidorPublico.Model;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="servidor_temporario")
public class ServidorTemporario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="st_admissao")
	private Date admissao;
	
	@Column(name="st_demissao")
	private Date demissao;
	
	
	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa ;
}

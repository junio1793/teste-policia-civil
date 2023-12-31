package br.gov.api.TesteServidorPublico.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name="foto_pesso")
public class FotoPessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long fp_id;
	@Column(name="fp_data")
	private Date data;
	@Column(name="fp_bucket")
	private String bucket;
	@Column(name = "fp_hash")
	private String hash;
	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;
	
}

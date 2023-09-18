package br.gov.api.TesteServidorPublico.Model;

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
public class Lotacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long lot_id;
	@Column(name="lot_data_lotacao")
	private Date ataLotacao;
	@Column(name="lot_data_remocao")
	private Date dataRemocao;
	@Column(name = "lot_portaria")
	private String portaria;

	@OneToOne
	@JoinColumn(name = "id_pessoa")
	private Pessoa pessoa ;
	@OneToOne
	@JoinColumn(name = "id_unidade")
	private Unidade unidade;
	
}

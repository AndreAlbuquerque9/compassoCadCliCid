package br.com.amonteiro.cadastroclientecidade.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Cidade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cidade;
	@ManyToOne
	private Estado estado;
	
	public Cidade(String cidade, Estado estado) {
		super();
		this.cidade = cidade;
		this.estado = estado;
	}
	
}

package br.com.amonteiro.cadastroclientecidade.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Character sexo;
	private LocalDate dataNascimento;
	private Integer idade;
	@OneToOne
	private Cidade cidade;

	public Cliente(String nome, Character sexo, LocalDate dataNascimento, Integer idade, Cidade cidade) {
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.idade = idade;
		this.cidade = cidade;
	}

}

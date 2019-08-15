package br.com.amonteiro.cadastroclientecidade.controller.form;

import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.amonteiro.cadastroclientecidade.model.Cidade;
import br.com.amonteiro.cadastroclientecidade.model.Cliente;
import br.com.amonteiro.cadastroclientecidade.repository.CidadeRepository;
import lombok.Data;

@Data
public class ClientForm {

	@NotNull
	@NotEmpty
	private String nome;
	@NotNull
	private Integer idade;
	@NotNull
	private LocalDate dataNascimento;
	@NotNull
	private Character sexo;
	@NotNull
	@NotEmpty
	private String nomeCidade;

	public Cliente converter(CidadeRepository cidadeRepository) {

		Cidade cidade = (Cidade) cidadeRepository.findByCidade(nomeCidade.toUpperCase()).get(0);
		return new Cliente(nome.toUpperCase(), sexo, dataNascimento, idade, cidade);
	}
}

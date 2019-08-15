package br.com.amonteiro.cadastroclientecidade.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.amonteiro.cadastroclientecidade.model.Cliente;
import br.com.amonteiro.cadastroclientecidade.repository.ClienteRepository;
import lombok.Data;

@Data
public class AtualizaClientForm {
	@NotEmpty
	@NotNull
	public String nome;

	public Cliente atualizar(Long id, ClienteRepository clienteRepository) {
		Cliente cliente = clienteRepository.getOne(id);

		cliente.setNome(this.nome.toUpperCase());

		return cliente;
	}
}
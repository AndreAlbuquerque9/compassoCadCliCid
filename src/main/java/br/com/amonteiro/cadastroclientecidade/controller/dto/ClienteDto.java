package br.com.amonteiro.cadastroclientecidade.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.amonteiro.cadastroclientecidade.model.Cliente;
import lombok.Data;

@Data
public class ClienteDto {

	public ClienteDto(Cliente cliente) {
		this.idCliente = cliente.getId();
		this.nome = cliente.getNome();
		this.idade = cliente.getIdade();
		this.dataNascimento = cliente.getDataNascimento();
		this.sexo = cliente.getSexo();
		this.cidade = cliente.getCidade().getCidade();
	}

	private Long idCliente;
	private String nome;
	private Integer idade;
	private LocalDate dataNascimento;
	private Character sexo;
	private String cidade;

	public static List<ClienteDto> converter(List<Cliente> clientes) {
		return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
}

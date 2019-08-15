package br.com.amonteiro.cadastroclientecidade.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.amonteiro.cadastroclientecidade.model.Cidade;
import lombok.Data;

@Data
public class CidadeDto {

	public CidadeDto(Cidade cidade) {
		this.idCidade = cidade.getId();
		this.estado = cidade.getEstado().getEstado();
		this.cidade = cidade.getCidade();
	}

	private Long idCidade;
	private String estado;
	private String cidade;
	
	public static List<CidadeDto> converter(List<Cidade> cidades) {
		return cidades.stream().map(CidadeDto::new).collect(Collectors.toList());
	}
}

package br.com.amonteiro.cadastroclientecidade.controller.form;

import br.com.amonteiro.cadastroclientecidade.model.Cidade;
import br.com.amonteiro.cadastroclientecidade.model.Estado;
import br.com.amonteiro.cadastroclientecidade.repository.EstadoRepository;
import lombok.Data;

@Data
public class CidadeForm {
	private String nomeCidade;
	private String nomeEstado;
	
	public Cidade converter(EstadoRepository estadoRepository) {
		
		Estado estado = estadoRepository.findByEstado(nomeEstado.toUpperCase());
		return new Cidade(nomeCidade.toUpperCase(), estado);
		
	}
}

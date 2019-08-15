package br.com.amonteiro.cadastroclientecidade.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.amonteiro.cadastroclientecidade.controller.dto.CidadeDto;
import br.com.amonteiro.cadastroclientecidade.controller.form.CidadeForm;
import br.com.amonteiro.cadastroclientecidade.model.Cidade;
import br.com.amonteiro.cadastroclientecidade.repository.CidadeRepository;
import br.com.amonteiro.cadastroclientecidade.repository.EstadoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CidadeController {

	private CidadeRepository cidadeRepository;
	private EstadoRepository estadoRepository;

	@GetMapping
	@RequestMapping({ "/cidades" })
	public List<CidadeDto> retornaCidade(String cidade) {
		if (cidade == null) {
			List<Cidade> cidades = cidadeRepository.findAll();
			return CidadeDto.converter(cidades);
		} else {
			List<Cidade> cidades = cidadeRepository.findByCidade(cidade.toUpperCase());
			return CidadeDto.converter(cidades);
		}
	}

	@GetMapping
	@RequestMapping({ "/estados" })
	public List<CidadeDto> retornaCidadePorEstado(String estado) {
		List<Cidade> cidadesPorEstado = cidadeRepository.findByEstadoEstado(estado.toUpperCase());
		return CidadeDto.converter(cidadesPorEstado);
	}

	@PostMapping({ "/cidades" })
	@Transactional
	public ResponseEntity<CidadeDto> cadastrarCidade(@RequestBody @Valid CidadeForm form,
			UriComponentsBuilder uriBuilder) {
		Cidade cidade = form.converter(estadoRepository);
		cidadeRepository.save(cidade);

		URI uri = uriBuilder.path("/cidades/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).body(new CidadeDto(cidade));

	}
}

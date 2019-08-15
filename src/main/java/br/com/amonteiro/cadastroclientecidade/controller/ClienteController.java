package br.com.amonteiro.cadastroclientecidade.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.amonteiro.cadastroclientecidade.controller.dto.ClienteDto;
import br.com.amonteiro.cadastroclientecidade.controller.form.AtualizaClientForm;
import br.com.amonteiro.cadastroclientecidade.controller.form.ClientForm;
import br.com.amonteiro.cadastroclientecidade.model.Cliente;
import br.com.amonteiro.cadastroclientecidade.repository.CidadeRepository;
import br.com.amonteiro.cadastroclientecidade.repository.ClienteRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping({ "/clientes" })
public class ClienteController {

	private ClienteRepository clienteRepository;
	private CidadeRepository cidadeRepository;

	@GetMapping
	public List<ClienteDto> retornaCliente(String nome) {
		if (nome == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return ClienteDto.converter(clientes);
		} else {
			List<Cliente> clientes = clienteRepository.findByNome(nome.toUpperCase());
			return ClienteDto.converter(clientes);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> retornaClientePorId(@PathVariable Long id) {
		Optional<Cliente> clientes = clienteRepository.findById(id);
		if (clientes.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(clientes.get()));
		}
		
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto> cadastrarCliente(@RequestBody @Valid ClientForm form,
			UriComponentsBuilder uriBuilder) {
		Cliente cliente = form.converter(cidadeRepository);
		clienteRepository.save(cliente);

		URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClienteDto> editarCliente(@PathVariable Long id, @RequestBody @Valid AtualizaClientForm form) {
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			Cliente cliente = form.atualizar(id, clienteRepository);
			return ResponseEntity.ok(new ClienteDto(cliente));
		}
		
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> removerCliente(@PathVariable Long id){
		Optional<Cliente> optional = clienteRepository.findById(id);
		if(optional.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}

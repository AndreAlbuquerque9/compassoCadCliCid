package br.com.amonteiro.cadastroclientecidade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amonteiro.cadastroclientecidade.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

	public List<Cidade> findByCidade(String nome);

	public List<Cidade> findByEstadoEstado(String nome);

}

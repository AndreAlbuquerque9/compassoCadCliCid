package br.com.amonteiro.cadastroclientecidade.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.amonteiro.cadastroclientecidade.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

	public Estado findByEstado(String nomeEstado);
}

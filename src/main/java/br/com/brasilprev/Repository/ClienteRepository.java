package br.com.brasilprev.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.brasilprev.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	List<Cliente> findBynome(String nome);
	
}

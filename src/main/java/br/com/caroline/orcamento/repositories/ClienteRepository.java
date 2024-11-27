package br.com.caroline.orcamento.repositories;

import br.com.caroline.orcamento.model.Cliente;
import br.com.caroline.orcamento.repositories.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>, ClienteRepositoryQuery {
}

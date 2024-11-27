package br.com.caroline.orcamento.repositories;

import br.com.caroline.orcamento.model.Lancamento;
import br.com.caroline.orcamento.repositories.lancamento.LancamentoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> , LancamentoRepositoryQuery {
}

package br.com.caroline.orcamento.repositories.lancamento;

import br.com.caroline.orcamento.dto.LancamentoDto;
import br.com.caroline.orcamento.repositories.filter.LancamentoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LancamentoRepositoryQuery {
    public Page<LancamentoDto> filtrar(LancamentoFilter lancamentoFilter, Pageable pageable0);
}

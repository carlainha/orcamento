package br.com.caroline.orcamento.repositories.cliente;

import br.com.caroline.orcamento.dto.ClienteDto;
import br.com.caroline.orcamento.repositories.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {

    public Page<ClienteDto> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}

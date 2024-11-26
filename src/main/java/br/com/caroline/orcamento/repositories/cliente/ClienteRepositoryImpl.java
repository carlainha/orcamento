package br.com.caroline.orcamento.repositories.cliente;

import br.com.caroline.orcamento.dto.ClienteDto;
import br.com.caroline.orcamento.model.Cliente;
import br.com.caroline.orcamento.repositories.filter.ClienteFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositoryImpl implements ClienteRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ClienteDto> filtrar(ClienteFilter clienteFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<ClienteDto> criteria = builder.createQuery(ClienteDto.class);
        Root<Cliente> root = criteria.from(Cliente.class);

        criteria.select(builder.construct(ClienteDto.class
                , root.get("nome")
                , root.get("endereco")
                , root.get("numero")
                ));

        Predicate[] predicates = criarRestricoes(clienteFilter, builder,root);
        criteria.where(predicates);
        criteria.orderBy()


        return null;
    }

    private Predicate[] criarRestricoes(ClienteFilter clienteFilter, CriteriaBuilder builder, Root<Cliente> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(clienteFilter.getNumero))
    }
}

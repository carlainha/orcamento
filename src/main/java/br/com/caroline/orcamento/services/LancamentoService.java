package br.com.caroline.orcamento.services;

import br.com.caroline.orcamento.model.Lancamento;
import br.com.caroline.orcamento.repositories.LancamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LancamentoService {
    @Autowired
    private LancamentoRepository lancamentoRepository;

    public Lancamento salvar(Lancamento lancamento){
        return lancamentoRepository.save(lancamento);
    }

    public Lancamento atualizar(Long id, Lancamento lancamento){
        Lancamento lancamentoSalva = buscarLancamentoExixstente(id);

        BeanUtils.copyProperties(lancamento, lancamentoSalva, "id");

        return  lancamentoRepository.save(lancamentoSalva);
    }
    private Lancamento buscarLancamentoExixstente(Long id) {
        Optional<Lancamento> lancamentoSalva = lancamentoRepository.findById(id);

        if(!lancamentoSalva.isPresent()) {
            throw new IllegalArgumentException();
        }
        return lancamentoSalva.get();
    }
}

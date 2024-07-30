package br.com.caroline.orcamento.services;

import br.com.caroline.orcamento.model.Cliente;
import br.com.caroline.orcamento.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }
}

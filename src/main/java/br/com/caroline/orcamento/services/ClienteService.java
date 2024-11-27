package br.com.caroline.orcamento.services;

import br.com.caroline.orcamento.model.Cliente;
import br.com.caroline.orcamento.model.Municipio;
import br.com.caroline.orcamento.repositories.ClienteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente atualizar(Long id, Cliente cliente){
        Cliente clienteSalva = buscarClienteExistente(id);

        BeanUtils.copyProperties(cliente, clienteSalva, "id");

        return clienteRepository.save(clienteSalva);
    }

    private Cliente buscarClienteExistente(Long id) {
        Optional<Cliente> clienteSalva = clienteRepository.findById(id);

        if (!clienteSalva.isPresent()) {
            throw  new IllegalArgumentException();
        }

        return clienteSalva.get();
    }
}

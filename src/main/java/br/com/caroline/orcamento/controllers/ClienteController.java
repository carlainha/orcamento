package br.com.caroline.orcamento.controllers;

import br.com.caroline.orcamento.model.Cliente;
import br.com.caroline.orcamento.repositories.ClienteRepository;
import br.com.caroline.orcamento.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping()
    public List<Cliente> ListarTodosClientes(){
        return clienteRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPeloId(@PathVariable Long id){
        Optional<Cliente> cliente=clienteRepository.findById(id);
        return cliente.isPresent()? ResponseEntity.ok(cliente.get()): ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Cliente> inserir (@RequestBody Cliente cliente){
        Cliente clienteSalva = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id){
        clienteRepository.deleteById(id);
    }
}

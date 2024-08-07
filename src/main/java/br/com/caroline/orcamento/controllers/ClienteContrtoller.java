package br.com.caroline.orcamento.controllers;

import br.com.caroline.orcamento.model.Cliente;
import br.com.caroline.orcamento.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClienteContrtoller {
    @Autowired
    private ClienteService clienteService;

    @PostMapping()
    public ResponseEntity<Cliente> inserir (@RequestBody Cliente cliente){
        Cliente clienteSalva = clienteService.salvar(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteSalva);
    }
}

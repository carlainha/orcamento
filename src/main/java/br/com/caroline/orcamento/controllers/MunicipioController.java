package br.com.caroline.orcamento.controllers;

import br.com.caroline.orcamento.model.Municipio;
import br.com.caroline.orcamento.repositories.MunicipioRepository;
import br.com.caroline.orcamento.repositories.filter.MunicipioFilter;
import br.com.caroline.orcamento.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/municipios")
public class MunicipioController {
    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private MunicipioRepository municipioRepository;

    @GetMapping()
    public Page<Municipio> pesquisar(MunicipioFilter categoriaFilter, Pageable pageable){
        return municipioRepository.filtrar(categoriaFilter, pageable);
    }

    @GetMapping("/todos")
    public List<Municipio> listarTodosMunicipios(){
        return municipioRepository.findAll(Sort.by("nome").ascending());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> buscarpPeloId(@PathVariable Long id){
        Optional<Municipio> municipio =municipioRepository.findById(id);
        return municipio.isPresent() ? ResponseEntity.ok(municipio.get()) : ResponseEntity.notFound().build();
    }
    @PostMapping()
    public ResponseEntity<Municipio> inserir (@RequestBody Municipio municipio){
        Municipio municipoSalva = municipioService.salvar(municipio);
        return ResponseEntity.status(HttpStatus.CREATED).body(municipoSalva);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long id){
        municipioRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Municipio> atualizar(@PathVariable Long id, @RequestBody Municipio municipio){
        Municipio municipioSalva = municipioService.atualizar(id,municipio);

        return ResponseEntity.ok(municipioSalva);
    }
}

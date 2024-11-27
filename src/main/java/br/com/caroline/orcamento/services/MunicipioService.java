package br.com.caroline.orcamento.services;

import br.com.caroline.orcamento.model.Municipio;
import br.com.caroline.orcamento.repositories.MunicipioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MunicipioService {
    @Autowired
    private MunicipioRepository municipioRepository;

    public Municipio salvar(Municipio municipio){
        return municipioRepository.save(municipio);
    }

    public Municipio atualizar(Long id, Municipio municipio){
        Municipio municipioSalva = buscarMunicipioExistente(id);

        BeanUtils.copyProperties(municipio, municipioSalva, "id");

        return municipioRepository.save(municipioSalva);
    }

    private Municipio buscarMunicipioExistente(Long id) {
        Optional<Municipio> municipioSalva = municipioRepository.findById(id);

        if (!municipioSalva.isPresent()){
            throw  new IllegalArgumentException();
        }

        return municipioSalva.get();

    }

}

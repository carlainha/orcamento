package br.com.caroline.orcamento.repositories;

import br.com.caroline.orcamento.model.Municipio;
import br.com.caroline.orcamento.repositories.municipio.MunicipioRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>, MunicipioRepositoryQuery {
}

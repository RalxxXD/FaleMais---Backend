package br.com.vizir.falemais.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import br.com.vizir.falemais.model.PrecoLigacaoDDD;

public interface PrecoLigacaoDDDRepository extends CrudRepository<PrecoLigacaoDDD, Long>{
	
	public List<PrecoLigacaoDDD> findAll();
	
	public Optional<PrecoLigacaoDDD> findByOrigemAndDestino(String origem, String destino);

}
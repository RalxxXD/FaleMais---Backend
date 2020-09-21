package br.com.vizir.falemais.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vizir.falemais.model.PrecoLigacaoDDD;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PrecoLigacaoDDDRepositoryTeste {
	
	@Autowired
	PrecoLigacaoDDDRepository ligacaoRepository;

	@Test
	public void deveRetornarTabelaPrecosDDD() {
		List<PrecoLigacaoDDD> dddPrecosVazio = new ArrayList<PrecoLigacaoDDD>();
		
		List<PrecoLigacaoDDD> dddPrecos = ligacaoRepository.findAll();
		
		assertNotEquals(dddPrecosVazio, dddPrecos);
		assertNotNull(dddPrecos);
	}
	
	@Test
	public void deveRetornarPrecosDeOgigemEDestino() {
		
		String origem = "011";
		String destino = "016";
		
		Optional<PrecoLigacaoDDD> dddPrecos = ligacaoRepository.findByOrigemAndDestino(origem, destino);
		
		assertEquals(origem, dddPrecos.get().getOrigem());
		assertEquals(destino, dddPrecos.get().getDestino());
		
	}
	
}

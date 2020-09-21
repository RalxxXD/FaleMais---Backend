package br.com.vizir.falemais.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.vizir.falemais.AppConfig;
import br.com.vizir.falemais.enums.Plano;
import br.com.vizir.falemais.model.PrecoLigacao;
import br.com.vizir.falemais.service.AtribuirPrecoLigacao;

@ContextConfiguration(classes = {AppConfig.class})
@RunWith(SpringRunner.class)
@SpringBootTest
public class AtribuirPrecoLigacaoImplTest {
	
	AtribuirPrecoLigacao atribuirPrecoLigacao;
	
	@Before
	public void inicializar() {
		atribuirPrecoLigacao = new AtribuirPrecoLigacaoImpl(new MinutoExcedentePlanoImpl());
	}

	@Test
	public void deveCalcularPrecoSemMinutosExcedentes() {
		
		long duracao = 30;
		double precoMinuto = 2.9;
		double precoLigacaoExperado = 87;
		double precoLigacaoPlanoExperado = 0;
		
		PrecoLigacao precoLigacao = atribuirPrecoLigacao.calcularPreco(duracao, precoMinuto, Plano.FALEMAIS30.getQtdMinutos());
		
		assertEquals(precoLigacaoExperado, precoLigacao.getPrecoLigacao(), 0.001);
		assertEquals(precoLigacaoPlanoExperado, precoLigacao.getPrecoLigacaoPLano(), 0.001);
		
	}
	
	@Test
	public void deveCalcularPrecoComMinutosExcedentes() {
		
		long duracao = 80;
		double precoMinuto = 2.9;
		double precoLigacaoExperado = 232;
		double precoLigacaoPlanoExperado = 63.8;
		
		PrecoLigacao precoLigacao = atribuirPrecoLigacao.calcularPreco(duracao, precoMinuto, Plano.FALEMAIS60.getQtdMinutos());
		
		assertEquals(precoLigacaoExperado, precoLigacao.getPrecoLigacao(), 0.001);
		assertEquals(precoLigacaoPlanoExperado, precoLigacao.getPrecoLigacaoPLano(), 0.001);
		
	}
	
}

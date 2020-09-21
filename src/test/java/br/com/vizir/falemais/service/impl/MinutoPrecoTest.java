package br.com.vizir.falemais.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.vizir.falemais.service.RegraDeCalculo;

public class MinutoPrecoTest {

	RegraDeCalculo minutoPreco;
	
	@Before
	public void inicializar() {
		minutoPreco = new MinutoPreco();
	}
	
	@Test
	public void deveRetornarPrecoMinutoAumentadoDezPorCento() {
		
		long qtdMinutos = 25;
		double precoMinuto = 1.9;
		double precoEsperado = 47.5;
		
		double precoCalculado = minutoPreco.calcular(qtdMinutos, precoMinuto);
		
		assertEquals(precoEsperado, precoCalculado, 0.0001);
		
	}

}

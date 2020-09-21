package br.com.vizir.falemais.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.vizir.falemais.service.RegraDeCalculo;

public class MinutoExcedenePrecoTest {

RegraDeCalculo minutoExcedentePreco;
	
	@Before
	public void inicializar() {
		minutoExcedentePreco = new MinutoExcedentePreco();
	}
	
	@Test
	public void deveRetornarPrecoMinutoAumentadoDezPorCento() {
		
		long qtdMinutos = 25;
		double precoMinuto = 1.9;
		double precoEsperadoSemAcressimo = 47.5;
		double precoEsperadoComAcressimo = 52.25;
		
		double precoCalculado = minutoExcedentePreco.calcular(qtdMinutos, precoMinuto);
		
		assertEquals(precoEsperadoComAcressimo, precoCalculado, 0.0001);
		assertNotEquals(precoEsperadoSemAcressimo, precoCalculado, 0.0001);
		
	}
	
}

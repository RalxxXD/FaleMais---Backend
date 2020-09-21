package br.com.vizir.falemais.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.vizir.falemais.enums.Plano;
import br.com.vizir.falemais.service.MinutoExcedentePlano;

public class MinutoExcedentePlanoImplTest {

	MinutoExcedentePlano minutoExcedentePlano;
	
	@Before
	public void inicializar() {
		minutoExcedentePlano = new MinutoExcedentePlanoImpl();
	}
	
	@Test
	public void deveRetornarMinutoExcedenteEmPlanoFaleMaisTrinta() {
		
		long duracao = 50;
		
		long minutosExcedentesPLano = minutoExcedentePlano.calcular(duracao, Plano.FALEMAIS30.getQtdMinutos());
		
		assertEquals(20, minutosExcedentesPLano);
		
	}
	
	@Test
	public void deveRetornarZeroMinutoExcedenteEmPlanoFaleMaisTrinta() {
		
		long duracao = 50;
		
		long minutosExcedentesPLano = minutoExcedentePlano.calcular(duracao, Plano.FALEMAIS60.getQtdMinutos());
		
		assertEquals(0, minutosExcedentesPLano);
		
	}
	
}

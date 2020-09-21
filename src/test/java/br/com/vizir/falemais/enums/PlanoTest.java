package br.com.vizir.falemais.enums;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PlanoTest {

	@Test
	public void deveRetornarUmPlanoValido() {
		
		String plano = "FaleMais60";
		long qtdMinutosEsperados = 60;
		
		Plano planoEscolhido = Plano.encontrarPlano(plano);
		
		assertEquals(qtdMinutosEsperados, planoEscolhido.getQtdMinutos());
		
	}
	
	@Test
	public void naoDeveRetornarPlano() {
		
		String plano = "FaleMais150";
		
		Plano planoEscolhido = Plano.encontrarPlano(plano);
		
		assertEquals(Plano.INVALIDO, planoEscolhido);
		
	}
	
}

package br.com.vizir.falemais.service.impl;

import br.com.vizir.falemais.service.RegraDeCalculo;

public class MinutoExcedentePreco implements RegraDeCalculo {
	
	private static final double DEZPORCENTO = 1.1;
	
	public double calcular(long qtdMinutos, double precoMinuto) {
		return (qtdMinutos * (precoMinuto * DEZPORCENTO));
	}
}

package br.com.vizir.falemais.service.impl;

import br.com.vizir.falemais.service.RegraDeCalculo;

public class MinutoPreco implements RegraDeCalculo {
	
	public double calcular(long qtdMinutos, double precoMinuto) {
		return qtdMinutos * precoMinuto;
	}

}

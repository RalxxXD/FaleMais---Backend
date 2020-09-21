package br.com.vizir.falemais.service.impl;

import br.com.vizir.falemais.service.MinutoExcedentePlano;

public class MinutoExcedentePlanoImpl implements MinutoExcedentePlano {

	public long calcular(long duracao, long qtdMinutosPlano) {
		long minutosExcedentes = duracao - qtdMinutosPlano;
		return minutosExcedentes > 0 ? minutosExcedentes : 0;
	}

}

package br.com.vizir.falemais.service;

import br.com.vizir.falemais.model.PrecoLigacao;

public interface AtribuirPrecoLigacao {
	
	public PrecoLigacao calcularPreco(long duracao, double precoMinuto, long qtdMinutosPlano);
}

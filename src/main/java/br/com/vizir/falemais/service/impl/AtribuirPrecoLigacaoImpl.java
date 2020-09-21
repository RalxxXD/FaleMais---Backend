package br.com.vizir.falemais.service.impl;

import org.springframework.stereotype.Service;

import br.com.vizir.falemais.model.PrecoLigacao;
import br.com.vizir.falemais.service.AtribuirPrecoLigacao;
import br.com.vizir.falemais.service.MinutoExcedentePlano;
import br.com.vizir.falemais.service.RegraDeCalculo;

@Service
public class AtribuirPrecoLigacaoImpl implements AtribuirPrecoLigacao {

	private static final double ZERO = 0;

	private final MinutoExcedentePlano minutoExcedentePlano;

	AtribuirPrecoLigacaoImpl(final MinutoExcedentePlano minutoExcedentePlano) {
		this.minutoExcedentePlano = minutoExcedentePlano;
	}

	public PrecoLigacao calcularPreco(long duracao, double precoMinuto, long qtdMinutosPlano) {

		double precoLigacao = aplicarRegraDeCalculo(new MinutoPreco(), duracao, precoMinuto);

		long minutosExcedente = minutoExcedentePlano.calcular(duracao, qtdMinutosPlano);

		if (minutosExcedente <= ZERO) {
			return new PrecoLigacao(ZERO, precoLigacao);
		}

		return new PrecoLigacao(aplicarRegraDeCalculo(new MinutoExcedentePreco(), minutosExcedente, precoMinuto),
				precoLigacao);

	}

	private double aplicarRegraDeCalculo(RegraDeCalculo regra, long qtdMinutos, double precoMinuto) {
		return regra.calcular(qtdMinutos, precoMinuto);
	}

}

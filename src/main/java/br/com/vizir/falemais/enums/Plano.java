package br.com.vizir.falemais.enums;

import java.util.Arrays;

public enum Plano {
	FALEMAIS30(30), FALEMAIS60(60), FALEMAIS120(120), INVALIDO(0);

	private long qtdMinutos;

	Plano(long qtdMinutos) {
		this.qtdMinutos = qtdMinutos;
	}

	public long getQtdMinutos() {
		return qtdMinutos;
	}

	public static Plano encontrarPlano(String nomePlano) {
		return Arrays.stream(Plano.values())
				.filter(plano -> plano.toString().equals(nomePlano.toUpperCase()))
				.findFirst().orElse(INVALIDO);
	}

}

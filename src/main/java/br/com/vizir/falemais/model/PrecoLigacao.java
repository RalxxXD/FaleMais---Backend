package br.com.vizir.falemais.model;

public class PrecoLigacao {
	
	private double precoLigacaoPLano;
	private double precoLigacao;
	private String error;
	
	public PrecoLigacao(double precoLigacaoPLano, double precoLigacao) {
		this.precoLigacaoPLano = precoLigacaoPLano;
		this.precoLigacao = precoLigacao;
	}
	
	public PrecoLigacao(String error) {
		this.error = error;
	}

	public double getPrecoLigacaoPLano() {
		return precoLigacaoPLano;
	}

	public double getPrecoLigacao() {
		return precoLigacao;
	}

	public String getError() {
		return error;
	}

}

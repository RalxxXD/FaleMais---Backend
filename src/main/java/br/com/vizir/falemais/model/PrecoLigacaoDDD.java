package br.com.vizir.falemais.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="precos_ligacao_ddd")
public class PrecoLigacaoDDD {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	private String origem;
	private String destino;
	@Column(name="preco")
	private double precoMinuto;
	
	public long getId() {
		return id;
	}
	public String getOrigem() {
		return origem;
	}
	public String getDestino() {
		return destino;
	}
	public double getPrecoMinuto() {
		return precoMinuto;
	}
	
}

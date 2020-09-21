package br.com.vizir.falemais.cotroller;

import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.vizir.falemais.enums.Plano;
import br.com.vizir.falemais.model.PrecoLigacaoDDD;
import br.com.vizir.falemais.model.PrecoLigacao;
import br.com.vizir.falemais.repository.PrecoLigacaoDDDRepository;
import br.com.vizir.falemais.service.AtribuirPrecoLigacao;

@Controller("valorLigacao")
public class ValorLigacaoController {

	@Autowired
	PrecoLigacaoDDDRepository precoLigacaoDDDRepository;

	@Autowired
	AtribuirPrecoLigacao atribuirPrecoLigacao;

	@GetMapping
	public ResponseEntity<PrecoLigacao> getPrecoLigacao(@PathParam("duracao") long duracao,
			@PathParam("origem") String origem, @PathParam("destino") String destino,
			@PathParam("plano") String plano) {
		
		try {

			Plano planoEscolhido = Plano.encontrarPlano(plano);
	
			if (planoEscolhido.equals(Plano.INVALIDO)) {
				return ResponseEntity.badRequest().body(new PrecoLigacao("Plano Invalido"));
			}
	
			Optional<PrecoLigacaoDDD> dadosLigacao = precoLigacaoDDDRepository.findByOrigemAndDestino(origem, destino);
	
			if (!dadosLigacao.isPresent()) {
				return ResponseEntity.badRequest().body(new PrecoLigacao("Valor de Origem ou Destino Invalidos"));
			}
	
			return ResponseEntity.ok()
					.body(atribuirPrecoLigacao.calcularPreco(duracao, dadosLigacao.get().getPrecoMinuto(), planoEscolhido.getQtdMinutos()));
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PrecoLigacao("Error de Servidor"));
		}
	}

}

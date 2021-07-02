package br.com.zupacademy.guilherme.proposta.CriaProposta;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "analise-api", url = "${zup.analise_financeira.url}/api")
public interface AnaliseCliente {

	@RequestMapping(method = RequestMethod.POST, value = "/solicitacao")
	ResultadoDaAnalise solicitacao(@RequestBody SolicitacaoDeAnaliseForm form);
}

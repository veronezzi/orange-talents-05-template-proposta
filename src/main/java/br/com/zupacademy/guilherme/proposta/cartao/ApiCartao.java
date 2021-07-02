package br.com.zupacademy.guilherme.proposta.cartao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(url = "${zup.cartoes.api.url}/api/cartoes", name = "recursos-cartao")
public interface ApiCartao {

	@GetMapping("/cartoes?idProposta={id}")
	CartaoForm getByPropostaId(@PathVariable("id") Long id);
}

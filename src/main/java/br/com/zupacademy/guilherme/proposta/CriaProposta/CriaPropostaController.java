package br.com.zupacademy.guilherme.proposta.CriaProposta;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import feign.FeignException.UnprocessableEntity;

@RestController
@RequestMapping("/cadastrarProposta")
public class CriaPropostaController {

	@PersistenceContext
	private EntityManager manager;

	@Autowired
	private AnaliseCliente analise;

	@PostMapping
	@Transactional
	public String cadastrarProposta(@RequestBody @Valid PropostaForm form) {
		Proposta proposta = form.toModel();
		manager.persist(proposta);
	

		StatusProposta status = StatusProposta.NAO_ELEGIVEL ;
		try {
			analise.solicitacao(new SolicitacaoDeAnaliseForm(proposta));
			status = StatusProposta.ELEGIVEL;
		} catch (UnprocessableEntity e) {
			status = StatusProposta.NAO_ELEGIVEL;
		} finally {
			proposta.setStatus(status);

		}
		return proposta.toString();
		
	}

}

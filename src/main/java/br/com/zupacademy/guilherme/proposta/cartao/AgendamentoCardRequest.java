package br.com.zupacademy.guilherme.proposta.cartao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.zupacademy.guilherme.proposta.CriaProposta.Proposta;
import br.com.zupacademy.guilherme.proposta.CriaProposta.PropostaRepository;

@Component
public class AgendamentoCardRequest {

	@Autowired
	PropostaRepository propostaRepository;

	@Autowired
	ApiCartao apiCartao;

	@Autowired
	CriarCartao criarCartao;

	@Scheduled(fixedDelayString = "${periodicidade.associar-cartao-a-uma-proposta}")
	public void executaOperacao() {
		List<Proposta> propostasAprovadas = propostaRepository.findAprovados();

		propostasAprovadas.forEach(proposta -> {
			try {
				CartaoForm cataoForm = apiCartao.getByPropostaId(proposta.getId());
				Cartao cartao = criarCartao.novoCartao(cataoForm);
				proposta.setCartao(cartao);
				propostaRepository.save(proposta);
			} catch (Exception e) {
				System.out.println(e);
			}
		});
	}
}

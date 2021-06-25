package br.com.zupacademy.guilherme.proposta.cartao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CriarCartao {

    @Autowired
    CartaoRepository cartaoRepository;

    public Cartao novoCartao(CartaoForm cartaoForm) {
    	Cartao card = cartaoForm.toModel();
    	cartaoRepository.save(card);

        return card;
    }

}

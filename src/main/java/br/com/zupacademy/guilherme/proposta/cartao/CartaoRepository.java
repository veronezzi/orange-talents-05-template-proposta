package br.com.zupacademy.guilherme.proposta.cartao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartaoRepository extends JpaRepository<Cartao, Long> {
    
}
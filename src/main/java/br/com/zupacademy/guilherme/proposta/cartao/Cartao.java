package br.com.zupacademy.guilherme.proposta.cartao;


import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Cartao {

    @Id
    private String id;
    
    @NotNull
    private LocalDateTime emissao;

    @NotNull
    private String titular;
    
    @NotNull
    private BigDecimal limite;

    public Cartao(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite) {
        this.id = id;
        this.emissao = emitidoEm;
        this.titular = titular;
        this.limite = limite;
    }

    @Deprecated
    public Cartao() {
    }


}

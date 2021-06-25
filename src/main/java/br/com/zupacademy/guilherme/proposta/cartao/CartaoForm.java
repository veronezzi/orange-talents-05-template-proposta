package br.com.zupacademy.guilherme.proposta.cartao;


import java.math.BigDecimal;
import java.time.LocalDateTime;


public class CartaoForm {

    private String id;
    private LocalDateTime emitidoEm;
    private String titular;
    private BigDecimal limite;
    private String idProposta;

    public CartaoForm(String id, LocalDateTime emitidoEm, String titular, BigDecimal limite, String idProposta) {
        this.id = id;
        this.emitidoEm = emitidoEm;
        this.titular = titular;
        this.limite = limite;
        this.idProposta = idProposta;
    }

    public String getId() {
        return this.id;
    }

    public LocalDateTime getEmitidoEm() {
        return this.emitidoEm;
    }

    public String getTitular() {
        return this.titular;
    }

    public BigDecimal getLimite() {
        return this.limite;
    }

    public String getIdProposta() {
        return this.idProposta;
    }

    public Cartao toModel() {
        return new Cartao(this.id, this.emitidoEm, this.titular, this.limite);
    }

}

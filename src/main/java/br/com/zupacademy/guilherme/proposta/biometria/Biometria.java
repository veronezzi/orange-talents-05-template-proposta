package br.com.zupacademy.guilherme.proposta.biometria;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guilherme.proposta.cartao.Cartao;

@Entity
public class Biometria {

    @Id
    private String id;

    @NotBlank
    @Column(nullable = false)
    private @NotBlank String imagens;

    @NotNull
    @ManyToOne
    private Cartao cartao;

    public Biometria(@NotBlank @NotBlank String imagemBase64, Cartao cartao) {
        this.imagens = imagemBase64;
        this.cartao = cartao;
    }

    public Biometria() {
    }

    public String getId() {
        return id;
    }

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
    }
}

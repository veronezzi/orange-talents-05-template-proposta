package br.com.zupacademy.guilherme.proposta.biometria;

import javax.validation.constraints.NotBlank;

import br.com.zupacademy.guilherme.proposta.cartao.Cartao;
import br.com.zupacademy.guilherme.proposta.validacao.Base64;



public class BiometriaForm {

    @NotBlank
    @Base64(message = "A imagem precisa estar em formato base64")
    private String imagemBase64;

    public void setImagemBase64(String imagemBase64) {
        this.imagemBase64 = imagemBase64;
    }

    public Biometria toModel(Cartao cartao) {
        return new Biometria(imagemBase64, cartao);
    }

}

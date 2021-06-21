package br.com.zupacademy.guilherme.proposta.CriaProposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guilherme.proposta.validacao.UniqueValue;
import br.com.zupacademy.guilherme.proposta.validacao.ValidadorDeCpfCnpj;

public class PropostaForm {

	@NotBlank
	@ValidadorDeCpfCnpj
	@UniqueValue(domainClass = Proposta.class, fieldName = "documento")
	private String documento;
	@Email
	@NotBlank
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	@NotNull
	private String endereco;
	@NotNull
	private BigDecimal salario;

	public PropostaForm(@NotBlank @ValidadorDeCpfCnpj String documento, @Email @NotBlank String email,
			@NotBlank String nome, @NotBlank @NotNull String endereco, @NotNull BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta toModel() {
		return new Proposta(this.documento, this.email, this.endereco, this.nome, this.salario);
	}

}

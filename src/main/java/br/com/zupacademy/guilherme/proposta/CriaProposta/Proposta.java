package br.com.zupacademy.guilherme.proposta.CriaProposta;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zupacademy.guilherme.proposta.validacao.ValidadorDeCpfCnpj;



@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@ValidadorDeCpfCnpj
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

	
	public Proposta(@NotNull @ValidadorDeCpfCnpj String documento, @Email @NotBlank String email, @NotNull String nome,
			@NotNull @NotNull String endereco, @NotNull BigDecimal salario) {
	
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", documento=" + documento + ", email=" + email + ", nome=" + nome + ", endereco="
				+ endereco + ", salario=" + salario + "]";
	}

}

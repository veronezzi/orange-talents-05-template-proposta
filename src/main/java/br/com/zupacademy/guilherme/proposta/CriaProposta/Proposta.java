package br.com.zupacademy.guilherme.proposta.CriaProposta;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


import br.com.zupacademy.guilherme.proposta.cartao.Cartao;
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

	@Enumerated(EnumType.STRING)
	private StatusProposta status;

	@OneToOne
	private Cartao cartao;
	
	

	public Proposta(@NotNull @ValidadorDeCpfCnpj String documento, @Email @NotBlank String email, @NotNull String nome,
			@NotNull @NotNull String endereco, @NotNull BigDecimal salario) {

		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Proposta [id=" + id + ", documento=" + documento + ", email=" + email + ", nome=" + nome + ", endereco="
				+ endereco + ", salario=" + salario + ", status=" + status + "]";
	}

	public void setStatus(StatusProposta status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}
	
	public StatusProposta getStatus() {
		return status;
	}

	@Deprecated
    public Proposta() {
    }
	

}

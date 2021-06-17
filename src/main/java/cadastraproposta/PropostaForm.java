package cadastraproposta;

import java.math.BigDecimal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class PropostaForm {

	@NotBlank
	private String documento;
	@Email
	@NotBlank
	private String email;
	private String nome;
	private String endereco;
	@NotEmpty
	private BigDecimal salario;

	public PropostaForm(@NotBlank String documento, @Email @NotBlank String email, String nome, String endereco,
			@NotEmpty BigDecimal salario) {
		super();
		this.documento = documento;
		this.email = email;
		this.nome = nome;
		this.endereco = endereco;
		this.salario = salario;
	}

	public Proposta toModel() {
		return new Proposta(this.documento,this.email,this.endereco,this.nome,this.salario);
	}

}

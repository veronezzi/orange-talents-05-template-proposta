package br.com.zupacademy.guilherme.proposta.CriaProposta;

public class SolicitacaoDeAnaliseForm {

	private Long idProposta;
	private String nome;
	private String documento;

	public SolicitacaoDeAnaliseForm(Proposta proposta) {
		this.idProposta = proposta.getId();
		this.nome = proposta.getNome();
		this.documento = proposta.getDocumento();
	}

	public Long getIdProposta() {
		return idProposta;
	}

	public String getNome() {
		return nome;
	}

	public String getDocumento() {
		return documento;
	}

}

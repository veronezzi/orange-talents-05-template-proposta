package br.com.zupacademy.guilherme.proposta.CriaProposta;

public class ResultadoDaAnalise {

	private String documento;
	private String nome;
	private String idProposta;
	private String resultadoSolicitacao;

	public ResultadoDaAnalise(String documento, String nome, String idProposta, String resultadoSolicitacao) {
		this.documento = documento;
		this.nome = nome;
		this.idProposta = idProposta;
		this.resultadoSolicitacao = resultadoSolicitacao;
	}

	StatusProposta statusDaProposta() {
		return resultadoSolicitacao == ResultadoDaSolicitacao.SEM_RESTRICAO.toString() ? StatusProposta.ELEGIVEL : StatusProposta.NAO_ELEGIVEL;

	}
	enum ResultadoDaSolicitacao{
		SEM_RESTRICAO,COM_RESTRICAO
	}

}

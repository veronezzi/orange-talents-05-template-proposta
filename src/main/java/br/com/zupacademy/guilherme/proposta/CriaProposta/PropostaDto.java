package br.com.zupacademy.guilherme.proposta.CriaProposta;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PropostaDto {

	private Long id;
	private String documento;
	
	private StatusProposta status;

	public PropostaDto(Proposta proposta) {
		id = proposta.getId();
		documento = proposta.getDocumento();
		status = proposta.getStatus();
	
	}

	public Long getId() {
		return id;
	}

	public String getDocumento() {
		return documento;
	}
	
	public StatusProposta getStatus() {
		return status;
	}

}

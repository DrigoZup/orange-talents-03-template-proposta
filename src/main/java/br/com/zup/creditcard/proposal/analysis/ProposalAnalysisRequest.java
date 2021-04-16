package br.com.zup.creditcard.proposal.analysis;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.creditcard.general.CpfOrCnpj;
import br.com.zup.creditcard.proposal.Proposal;

public class ProposalAnalysisRequest {

	@CpfOrCnpj
	@NotBlank
	@JsonProperty("documento")
	private String document;
	
	@NotBlank
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("idProposta")
	private String idProposal;
	
	public ProposalAnalysisRequest(Proposal proposal) {
		this.document = proposal.getDocument();
		this.name = proposal.getName();
		this.idProposal = proposal.getId().toString();
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getIdProposal() {
		return idProposal;
	}
	
}

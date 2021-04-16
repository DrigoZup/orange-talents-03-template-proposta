package br.com.zup.creditcard.proposal.analysis;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.zup.creditcard.proposal.ProposalStatus;

public class ProposalAnalysisResponse {

	@JsonProperty("documento")
	private String document;
	@JsonProperty("nome")
	private String name;
	@JsonProperty("resultadoSolicitacao")
	private String analysisResult;
	@JsonProperty("idProposta")
	private String proposalId;

	public ProposalAnalysisResponse(String document, String name, String analysisResult, String proposalId) {
		this.document = document;
		this.name = name;
		this.analysisResult = analysisResult;
		this.proposalId = proposalId;
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getAnalysisResult() {
		return analysisResult;
	}

	public String getProposalId() {
		return proposalId;
	}
	
	public ProposalStatus verifyStatus () {
			if("COM_RESTRICAO".equals(analysisResult)) {
				return ProposalStatus.NOT_ELIGIBLE;
			}
			return ProposalStatus.ELIGIBLE;
		}
}

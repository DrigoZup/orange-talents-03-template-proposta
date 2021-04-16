package br.com.zup.creditcard.proposal;

public class ProposalResponse {

	private String document;

	private String name;

	private String email;

	public ProposalResponse(Proposal proposal) {
		this.document = proposal.getDocument();
		this.name = proposal.getName();
		this.email = proposal.getEmail();
	}

	public String getDocument() {
		return document;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}
	
}

package br.com.zup.creditcard.proposal.analysis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.creditcard.proposal.Proposal;
import br.com.zup.creditcard.proposal.ProposalStatus;
import feign.FeignException;

@Service
public class ProposalAnalysisSubmitter {

	@Autowired
	private ProposalAnalysisClient proposalAnalysisClient;

	public ProposalStatus submitForAnalysis(Proposal proposal) {
		try {
			ProposalAnalysisResponse analysisResponse = proposalAnalysisClient.submitForAnalysis(proposal);
			return analysisResponse.verifyStatus();
		} catch (FeignException.UnprocessableEntity e ) {
			return ProposalStatus.NOT_ELIGIBLE;
		}
	}
}

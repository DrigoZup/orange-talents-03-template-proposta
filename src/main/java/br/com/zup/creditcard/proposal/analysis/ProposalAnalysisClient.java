package br.com.zup.creditcard.proposal.analysis;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "proposal-analysis", url = "${proposal-analysis.targetUrl}")
public interface ProposalAnalysisClient {

	@PostMapping("/api/solicitacao")
	@Transactional
	ProposalAnalysisResponse submitForAnalysis(@RequestBody @Valid ProposalAnalysisRequest request);
}

package br.com.zup.creditcard.proposal;

import java.net.URI;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.creditcard.general.ResponseDto;
import br.com.zup.creditcard.proposal.analysis.ProposalAnalysisSubmitter;

@RestController
@RequestMapping("/proposals")
@Transactional
public class ProposalController {

	@Autowired
	ProposalRepository repository;

	@Autowired
	ProposalAnalysisSubmitter proposalAnalysis;

	@PostMapping
	public ResponseEntity<?> createProposal(@RequestBody @Valid ProposalRequest request,
			UriComponentsBuilder uriBuilder) {

		boolean verifyDocumentExistence = repository.existsByDocument(request.getDocument());
		if (verifyDocumentExistence) {
			return ResponseEntity.unprocessableEntity().body(new ResponseDto("Duplicated Argument"));
		}
		Proposal proposal = request.convertToEntity();

		ProposalStatus status = proposalAnalysis.submitForAnalysis(proposal);
		proposal.updateStatus(status);

		repository.save(proposal);

		URI uri = uriBuilder.path("proposals/{id}").buildAndExpand(proposal.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProposalResponse(proposal));
	}

}

package br.com.zup.creditcard.proposal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProposalRepository extends CrudRepository<Proposal, Long>{

	public boolean existsByDocument(String document);
}

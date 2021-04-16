package br.com.zup.creditcard.proposal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String document;
	
	private String name;
	
	private String email;
	
	private String address;
	
	private Double salary;
	
	@Enumerated(EnumType.STRING)
	private ProposalStatus status = ProposalStatus.NOT_ELIGIBLE;

	@Deprecated
	public Proposal() {
		
	}
	
	public Proposal(String document, String name, String email, String address, Double salary) {
		this.document = document;
		this.name = name;
		this.email = email;
		this.address = address;
		this.salary = salary;
	}

	public Long getId() {
		return id;
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

	public String getAddress() {
		return address;
	}
	
	public Double getSalary() {
		return salary;
	}
	
	public ProposalStatus getStatus() {
		return status;
	}
	
	public void updateStatus(ProposalStatus status) {
		this.status = status;
	}
	
}

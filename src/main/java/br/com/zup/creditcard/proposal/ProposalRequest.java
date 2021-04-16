package br.com.zup.creditcard.proposal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import br.com.zup.creditcard.general.CpfOrCnpj;

public class ProposalRequest {

	@NotBlank
	@CpfOrCnpj
	private String document;

	@NotBlank
	private String name;

	@NotNull
	@Email
	private String email;

	private String address;

	@NotNull
	@Positive
	private Double salary;

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

	public Proposal convertToEntity() {
		return new Proposal(document, name, email, address, salary);
	}

}

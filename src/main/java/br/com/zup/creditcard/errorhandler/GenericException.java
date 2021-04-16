package br.com.zup.creditcard.errorhandler;

public class GenericException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GenericException(String response) {
		super(response);
	}
}

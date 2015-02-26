package br.com.caelum.jdbc.exception;

public class DAOException extends RuntimeException {

	public DAOException() {
		super("Erro desconhecido!");
	}
	
	public DAOException(Exception ex) {
		super(ex);
	}
	
}

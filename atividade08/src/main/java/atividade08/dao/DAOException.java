package atividade08.dao;

public class DAOException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DAOException() {
		super();
	}

	public DAOException(String mensagem) {
		super(mensagem);
	}

	public DAOException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

	public DAOException(Throwable causa) {
		super(causa);
	}

}

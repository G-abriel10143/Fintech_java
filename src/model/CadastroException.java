package model;

public class CadastroException extends Exception {
	private static final long serialVersionUID = 1L;

	public <T extends Entity> CadastroException(Class<T> clazz, String message) {
		super("Erro ao cadastrar Entidade '" + clazz + "'. " + message);
	}
}

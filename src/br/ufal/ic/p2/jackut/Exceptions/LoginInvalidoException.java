package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando o login de um usu�rio � inv�lido.
 */
public class LoginInvalidoException extends RuntimeException {
    public LoginInvalidoException() {
        super("Login inv�lido.");
    }
}

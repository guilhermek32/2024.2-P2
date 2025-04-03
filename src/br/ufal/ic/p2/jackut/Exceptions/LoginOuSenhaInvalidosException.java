package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando o login ou a senha de um usu�rio s�o inv�lidos.
 */
public class LoginOuSenhaInvalidosException extends RuntimeException {
    public LoginOuSenhaInvalidosException() {
        super("Login ou senha inv�lidos.");
    }
}

package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando um usu�rio tenta criar uma conta com um login que j� existe.
 */
public class LoginJaExisteException extends RuntimeException {
    public LoginJaExisteException() {
        super("Login j� existe.");
    }
}

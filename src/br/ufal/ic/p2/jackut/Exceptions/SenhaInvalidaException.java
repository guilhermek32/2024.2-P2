package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando a senha de um usu�rio � inv�lida.
 */
public class SenhaInvalidaException extends RuntimeException {
    public SenhaInvalidaException() {
        super("Senha inv�lida.");
    }
}

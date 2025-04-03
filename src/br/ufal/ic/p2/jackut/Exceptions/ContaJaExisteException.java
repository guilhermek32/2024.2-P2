package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exce��o lan�ada quando uma conta com o mesmo nome j� existe.
 */
public class ContaJaExisteException extends RuntimeException {
    public ContaJaExisteException() {
        super("Conta com esse nome j� existe.");
    }
}

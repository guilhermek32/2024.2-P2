package br.ufal.ic.p2.jackut.Exceptions;

/**
 * Exceção lançada quando uma conta com o mesmo nome já existe.
 */
public class ContaJaExisteException extends RuntimeException {
    public ContaJaExisteException() {
        super("Conta com esse nome já existe.");
    }
}
